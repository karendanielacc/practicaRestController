package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Vegetal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiendaUseCase {

    @Autowired
    private CarneUseCase carneUseCase;

    @Autowired
    private LacteoUseCase lacteoUseCase;

    @Autowired
    private VegetalUseCase vegetalUseCase;

    private static List<Carne> carnes;
    private static List<Vegetal> vegetales;
    private static List<Lacteo> lacteos;

    public Flux<Carne> llenarInventarioCarnes() throws IOException {
        cargarCarnes("src/main/resources/carnes.txt");
        return carneUseCase.agregarCarnesAll(carnes);
    }

    public Flux<Vegetal> llenarInventarioVegetales() throws IOException {
        cargarVegetales("src/main/resources/vegetales.txt");

        return vegetalUseCase.agregarVegetalesAll(vegetales);
    }

    public Flux<Lacteo> llenarInventarioLacteos() throws IOException {
        cargarLacteos("src/main/resources/lacteos.txt");

        return lacteoUseCase.agregarLacteosAll(lacteos);
    }

    private static void cargarCarnes (String ruta) throws IOException {
        Path file = Path.of(ruta);
        Stream<String> lines = Files.lines(file);
        carnes = lines.map(line -> {
            String[] atributes = line.split(",");
            return new Carne(atributes[0], atributes[1], Double.parseDouble(atributes[2]), atributes[3], Double.parseDouble(atributes[4]));
        }).collect(Collectors.toList());

    }
    private static void cargarVegetales (String ruta) throws IOException {
        Path file = Path.of(ruta);
        Stream<String> lines = Files.lines(file);
        vegetales = lines.map(line -> {
            String[] atributes = line.split(",");
            return new Vegetal(atributes[0], atributes[1], Double.parseDouble(atributes[2]), Double.parseDouble(atributes[3]),
                    atributes[4], atributes[5], Double.parseDouble(atributes[6]));
        }).collect(Collectors.toList());

    }

    private static void cargarLacteos (String ruta) throws IOException {
        Path file = Path.of(ruta);
        Stream<String> lines = Files.lines(file);
        lacteos = lines.map(line -> {
            String[] atributes = line.split(",");
            return new Lacteo(atributes[0], atributes[1], Double.parseDouble(atributes[2]), atributes[3], Double.parseDouble(atributes[4]));
        }).collect(Collectors.toList());
    }


}
