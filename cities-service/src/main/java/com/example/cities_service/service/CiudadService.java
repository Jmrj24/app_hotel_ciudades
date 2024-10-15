package com.example.cities_service.service;

import com.example.cities_service.dto.CiudadDTO;
import com.example.cities_service.model.Ciudad;
import com.example.cities_service.repository.ICiudadRepository;
import com.example.cities_service.repository.IHotelApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService implements ICiudadService{
    @Autowired
    private ICiudadRepository ciudadRepo;

    @Autowired
    private IHotelApi hotelApi;

    @Override
    public void saveCiudad(Ciudad ciudad) {
        ciudadRepo.saveCiudad(ciudad);
    }

    @Override
    public List<Ciudad> getAllCiudades() {
        return ciudadRepo.getAllCiudades();
    }

    @Override
    public Ciudad getCiudadById(int id) {
        return ciudadRepo.getCiudadById(id);
    }

    @Override
    public void deleteCiudad(int id) {
        ciudadRepo.deleteCiudad(id);
    }

    @Override
    public void editCiudad(int id, Ciudad ciudad) {
        ciudadRepo.editCiudad(id, ciudad);
    }

    @Override
    @CircuitBreaker(name="hotels-service", fallbackMethod ="fallbackGetCiudad")
    @Retry(name="hotels-service")
    public CiudadDTO getCiudadByNombre(String nombreCiudad, String pais) {
        Ciudad ciudadEncontrada = this.findCity(nombreCiudad, pais);

        CiudadDTO ciudadDTO = new CiudadDTO();
        ciudadDTO.setId(ciudadEncontrada.getId());
        ciudadDTO.setNombre(ciudadEncontrada.getNombre());
        ciudadDTO.setContinente(ciudadEncontrada.getContinente());
        ciudadDTO.setPais(ciudadEncontrada.getPais());
        ciudadDTO.setProvincia(ciudadEncontrada.getProvincia());

        ciudadDTO.setListaHoteles(hotelApi.getAllHotelesByCiudad(ciudadEncontrada.getId()));

        createException();

        return ciudadDTO;
    }

    public CiudadDTO fallbackGetCiudad (Throwable throwable) {
        return new CiudadDTO(9999, "Fallido", "Fallido", "Fallido", "Fallido", null);
    }

    public void createException() {
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

    public Ciudad findCity(String nombreCiudad, String pais) {
        List<Ciudad> listaCiudades = this.getAllCiudades();

        for(Ciudad ciu:listaCiudades) {
            if(nombreCiudad.equals(ciu.getNombre())) {
                if(pais.equals(ciu.getPais())) {
                    return ciu;
                }
            }
        }
        return null;
    }
}
