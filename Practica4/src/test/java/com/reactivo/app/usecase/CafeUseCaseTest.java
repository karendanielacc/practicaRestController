package com.reactivo.app.usecase;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@AllArgsConstructor
class CafeUseCaseTest {

    private CafeUseCase cafeUseCase;

    @MockBean
    private CafeRepository repository;

    @BeforeEach
    void beforeEach(){
        repository = Mockito.mock(CafeRepository.class);
        cafeUseCase = new CafeUseCase(repository);
    }

    //TODO: Ajustar el metodo obtenerCostoTotalCafeCadena y el test
    @Test
    void obtenerCostoTotalCafeCadenaCafeConDatosNoCero() {
        Empaque empaquePrueba = new Empaque("empaquePrueba", "Prueba empaque", 10f,
                1f, 100);
        Cafe cafePrueba = new Cafe("A001", "variedadPrueba",100,
                "regionPrueba",12f, 10f,empaquePrueba);

        String resultadoEsperado = "El costo total de este cafe es 12.010.01.00.099999994";

        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(cafePrueba.getSerial()).block());
    }

    @Test
    void obtenerCostoTotalCafeCadenaCafeNulo() {
        String resultadoEsperado = "El cafe no existe";
        //Recordar usar any() para crear el mock de findCafeBySerial con cualquier parametro posible
        Mockito.when(repository.findCafeBySerial(any())).thenReturn(null);

        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(null).block());
    }

    @Test
    void obtenerCostoTotalCafeCadenaCafeEmpaqueNulo() {
        String resultadoEsperado = "El cafe no tiene empaque";
        Cafe cafePrueba = new Cafe("A001", "variedadPrueba",100,
                "regionPrueba",12f, 10f, null);
        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(cafePrueba.getSerial()).block());
    }

    @Test
    void obtenerCostoTotalCafeCadenaCafeCostoPrecioPesoCero() {
        Empaque empaquePrueba = new Empaque("empaquePrueba", "Prueba empaque", 0f,
                0f, 100);
        Cafe cafePrueba = new Cafe("A001", "variedadPrueba",100,
                "regionPrueba",0f, 0f,empaquePrueba);

        String resultadoEsperado = "El costo total de este cafe es 0.00.00.00.0";

        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(cafePrueba.getSerial()).block());
    }
}