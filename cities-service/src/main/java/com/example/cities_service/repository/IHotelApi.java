package com.example.cities_service.repository;

import com.example.cities_service.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelApi {
    @GetMapping("/hotel/traer/ciudad/{idCiudad}")
    public List<HotelDTO> getAllHotelesByCiudad(@PathVariable("idCiudad") int idCiudad);
}
