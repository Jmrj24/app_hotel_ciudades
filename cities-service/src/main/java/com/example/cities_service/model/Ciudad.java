package com.example.cities_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {
    private int id;
    private String nombre;
    private String continente;
    private String pais;
    private String provincia;
}
