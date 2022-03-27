package com.reactivo.app.controller;

import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.usecase.LacteoUseCase;
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
@RequestMapping("/lacteo")
@AllArgsConstructor
public class LacteoController {

    @Autowired
    private LacteoUseCase lacteoUseCase;

    @PostMapping("/agregarlacteo")
    public Mono<Lacteo> agregarLacteo(@RequestBody Lacteo lacteo){
        return lacteoUseCase.agregarLacteo(lacteo);
    }

    @GetMapping("/verlacteo/{id}")
    public Mono<Lacteo> verLacteo(@PathVariable String id){
        return lacteoUseCase.verLacteo(id);
    }

    @GetMapping("/verlacteos")
    public Flux<Lacteo> verLacteos(){
        return lacteoUseCase.verLacteos();
    }

    @PutMapping("/actualizarlacteo")
    public Mono<Lacteo> actualizarLacteo(@RequestBody Lacteo lacteo){
        return lacteoUseCase.agregarLacteo(lacteo);
    }

    @DeleteMapping("/eliminarlacteo/{id}")
    public Mono<Void> eliminarLacteo(@PathVariable String id){
        return lacteoUseCase.eliminarLacteo(id);
    }
}
