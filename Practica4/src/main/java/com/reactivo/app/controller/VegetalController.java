package com.reactivo.app.controller;

import com.reactivo.app.modelos.Vegetal;
import com.reactivo.app.usecase.VegetalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vegetal")
@AllArgsConstructor
public class VegetalController {

    @Autowired
    private VegetalUseCase vegetalUseCase;

    @PostMapping("/agregarvegetal")
    public Mono<Vegetal> agregarVegetal(@RequestBody Vegetal vegetal){
        return vegetalUseCase.agregarVegetal(vegetal);
    }

    @GetMapping("/vervegetal/{id}")
    public Mono<Vegetal> verVegetal(@PathVariable String id){
        return vegetalUseCase.verVegetal(id);
    }

    @GetMapping("/vervegetales")
    public Flux<Vegetal> verVegetales(){
        return vegetalUseCase.verVegetales();
    }

    @PutMapping("/actualizarvegetal")
    public Mono<Vegetal> actualizarVegetal(@RequestBody Vegetal vegetal){
        return vegetalUseCase.agregarVegetal(vegetal);
    }

    @DeleteMapping("/eliminarvegetal/{id}")
    public Mono<Void> eliminarVegetal(@PathVariable String id){
        return vegetalUseCase.eliminarVegetal(id);
    }
}
