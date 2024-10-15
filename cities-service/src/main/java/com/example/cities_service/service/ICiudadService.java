package com.example.cities_service.service;

import com.example.cities_service.dto.CiudadDTO;
import com.example.cities_service.model.Ciudad;

import java.util.List;

public interface ICiudadService {
    public void saveCiudad(Ciudad ciudad);

    public List<Ciudad> getAllCiudades();

    public Ciudad getCiudadById(int id);

    public void deleteCiudad(int id);

    public void editCiudad(int id, Ciudad ciudad);

    public CiudadDTO getCiudadByNombre(String nombreCiudad, String pais);
}
