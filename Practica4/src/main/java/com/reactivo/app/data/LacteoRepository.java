package com.reactivo.app.data;

import com.reactivo.app.modelos.Lacteo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LacteoRepository extends ReactiveMongoRepository<Lacteo, String> {
}
