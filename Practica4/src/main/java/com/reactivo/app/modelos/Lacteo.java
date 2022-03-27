package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "lacteo")
public class Lacteo {
    @Id
    private String id;
    private String tipo;
    private double peso;
    private String presentacion;
    private double precio;

}
