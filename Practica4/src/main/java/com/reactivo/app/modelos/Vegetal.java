package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "vegetal")
public class Vegetal {
    @Id
    private String id;
    private String nombre;
    private double precio;
    private double peso;
    private String presentacion;
    private String sueloCultivo;
    private double alturaCultivo;
}
