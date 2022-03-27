package com.reactivo.app.data;

import com.reactivo.app.modelos.Vegetal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VegetalRepository extends ReactiveMongoRepository<Vegetal, String> {
}
