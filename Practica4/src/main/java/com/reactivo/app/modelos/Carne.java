package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "carne")
public class Carne {
    @Id
    private String id;
    private String nombre;
    private double precio;
    private String maduracion;
    private double pesoGramos;

}
