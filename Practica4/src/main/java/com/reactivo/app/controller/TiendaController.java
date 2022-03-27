package com.reactivo.app.controller;

import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Vegetal;
import com.reactivo.app.usecase.TiendaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    private TiendaUseCase tiendaUseCase;

    @PostMapping("/llenarinventario/carnes")
    public Flux<Carne> llenarInventarioCarnes() throws IOException {
        return tiendaUseCase.llenarInventarioCarnes();
    }

    @PostMapping("/llenarinventario/vegetales")
    public Flux<Vegetal> llenarInventarioVegetal() throws IOException {
        return tiendaUseCase.llenarInventarioVegetales();
    }

    @PostMapping("/llenarinventario/lacteos")
    public Flux<Lacteo> llenarInventarioLacteo() throws IOException {
        return tiendaUseCase.llenarInventarioLacteos();
    }
}
