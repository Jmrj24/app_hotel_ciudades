package com.example.cities_service.repository;

import com.example.cities_service.model.Ciudad;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CiudadRepository implements ICiudadRepository {
    List<Ciudad> listaCiudades = new ArrayList<>();

    @Override
    public void saveCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
    }

    @Override
    public List<Ciudad> getAllCiudades() {
        if(listaCiudades.isEmpty()) {
            this.loadCiudades();
        }
        return listaCiudades;
    }

    @Override
    public Ciudad getCiudadById(int id) {
        return listaCiudades.get(id-1);
    }

    @Override
    public void deleteCiudad(int id) {
        listaCiudades.remove(id);
    }

    @Override
    public void editCiudad(int id, Ciudad ciudad) {

    }

    public void loadCiudades () {
        listaCiudades.add(new Ciudad(1, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        listaCiudades.add(new Ciudad(2, "Oberá", "South America", "Argentina", "Misiones"));
        listaCiudades.add(new Ciudad(3, "Mexico City", "North America", "Mexico", "Mexico City"));
        listaCiudades.add(new Ciudad(4, "Guadalajara", "North America", "Mexico", "Jalisco"));
        listaCiudades.add(new Ciudad(5, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        listaCiudades.add(new Ciudad(6, "Medellín", "South America", "Colombia", "Antioquia"));
        listaCiudades.add(new Ciudad(7, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        listaCiudades.add(new Ciudad(8, "Valparaíso", "South America", "Chile", "Valparaíso"));
        listaCiudades.add(new Ciudad(9, "Asunción", "South America", "Paraguay", "Asunción"));
        listaCiudades.add(new Ciudad(10, "Montevideo", "South America", "Uruguay", "Montevideo"));
        listaCiudades.add(new Ciudad(11, "Madrid", "Europe", "Spain", "Community of Madrid"));
        listaCiudades.add(new Ciudad(12, "Barcelona", "Europe", "Spain", "Catalonia"));
        listaCiudades.add(new Ciudad(13, "Seville", "Europe", "Spain", "Andalucia"));
        listaCiudades.add(new Ciudad(14, "Monterrey", "North America", "Mexico", "Nuevo León"));
        listaCiudades.add(new Ciudad(15, "Valencia", "Europe", "Spain", "Valencian Community"));
    }
}
