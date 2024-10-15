package com.example.hotels_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private int id;
    private String nombre;
    private int cantEstrellas;
    private int idCiudad;
}
