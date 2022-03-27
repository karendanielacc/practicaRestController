package com.reactivo.app.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CafeController.class)
class CafeControllerTest {

    @MockBean
    CafeUseCase cafeUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getCafeById() {

        /*Se agrega el Mockito.when para asegurar que cafeUseCase
        retorne un Cafe cuando se llama un getCafeById, y con el mismo ID siempre (el mismo serial)*/
        String serialCafePrueba = "00A3";

        Cafe cafePrueba = new Cafe(serialCafePrueba,"prueba",1200, "region prueba",
                10f, 10f, new Empaque());

        Mockito.when(cafeUseCase.getCafeBySerialMono(serialCafePrueba)).thenReturn(Mono.just(cafePrueba));

        webTestClient.get()
                .uri("/cafe/"+serialCafePrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cafe.class);


        /*Se agrega el Mockito.verify para validar que desde cafeUseCase
        se llamo el metodo getCafeBySerialMono una vez:*/
        Mockito.verify(cafeUseCase, Mockito.times(1)).getCafeBySerialMono(serialCafePrueba);

    }
}