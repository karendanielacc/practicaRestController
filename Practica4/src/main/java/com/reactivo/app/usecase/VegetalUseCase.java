package com.reactivo.app.usecase;

import com.reactivo.app.data.VegetalRepository;
import com.reactivo.app.modelos.Vegetal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VegetalUseCase {

    @Autowired
    private VegetalRepository vegetalRepository;

    public Mono<Vegetal> verVegetal(String id){
        return vegetalRepository.findById(id);
    }

    public Flux<Vegetal> verVegetales(){
        return vegetalRepository.findAll();
    }

    public Mono<Void> eliminarVegetal(String id){
        return vegetalRepository.deleteById(id);
    }

    public Mono<Vegetal> agregarVegetal(Vegetal vegetal){
        return vegetalRepository.save(vegetal);
    }

    public Flux<Vegetal> agregarVegetalesAll(List<Vegetal> vegetales){
        return vegetalRepository.saveAll(vegetales);
    }
}
