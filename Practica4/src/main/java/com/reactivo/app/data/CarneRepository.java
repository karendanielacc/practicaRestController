package com.reactivo.app.data;

import com.reactivo.app.modelos.Carne;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarneRepository extends ReactiveMongoRepository<Carne, String> {
}
