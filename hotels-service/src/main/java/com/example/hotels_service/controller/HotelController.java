package com.example.hotels_service.controller;

import com.example.hotels_service.model.Hotel;
import com.example.hotels_service.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private IHotelService hotelServ;

    @PostMapping("/crear")
    public String saveHotel(@RequestBody Hotel hotel) {
        hotelServ.saveHotel(hotel);
        return "Hotel creado de manera exitosa!";
    }

    @GetMapping("/traer")
    public List<Hotel> getAllHoteles() {
        return hotelServ.getAllHoteles();
    }

    @GetMapping("/traer/ciudad/{idCiudad}")
    public List<Hotel> getAllHotelesByCiudad(@PathVariable int idCiudad) {
        return hotelServ.getAllHotelesByCiudad(idCiudad);
    }
}
