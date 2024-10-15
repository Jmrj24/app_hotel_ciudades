package com.example.cities_service.repository;

import com.example.cities_service.model.Ciudad;

import java.util.List;

public interface ICiudadRepository {
    public void saveCiudad(Ciudad ciudad);

    public List<Ciudad> getAllCiudades();

    public Ciudad getCiudadById(int id);

    public void deleteCiudad(int id);

    public void editCiudad(int id, Ciudad ciudad);
}
