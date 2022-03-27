package com.reactivo.app.usecase;

import com.reactivo.app.data.CarneRepository;
import com.reactivo.app.modelos.Carne;
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
public class CarneUseCase {

    @Autowired
    private CarneRepository carneRepository;

    public Mono<Carne> verCarne(String id){
        return carneRepository.findById(id);
    }

    public Flux<Carne> verCarnes(){
        return carneRepository.findAll();
    }

    public Mono<Void> eliminarCarne(String id){
        return carneRepository.deleteById(id);
    }

    public Mono<Carne> agregarCarne(Carne carne){
        return carneRepository.save(carne);
    }

    public Flux<Carne> agregarCarnesAll(List<Carne> carnes){
        return carneRepository.saveAll(carnes);
    }

}
