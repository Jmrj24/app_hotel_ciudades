package com.example.cities_service.controller;

import com.example.cities_service.dto.CiudadDTO;
import com.example.cities_service.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    @Autowired
    private ICiudadService ciudadServ;

    @GetMapping("/traer/info")
    public CiudadDTO getCiudadByNombre(@RequestParam String nombreCiudad,
                                       @RequestParam String pais) {
        return ciudadServ.getCiudadByNombre(nombreCiudad, pais);
    }
}
