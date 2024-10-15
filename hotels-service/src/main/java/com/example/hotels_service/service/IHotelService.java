package com.example.hotels_service.service;

import com.example.hotels_service.model.Hotel;

import java.util.List;

public interface IHotelService {
    public void saveHotel(Hotel hotel);

    public List<Hotel> getAllHoteles();

    public Hotel getHotelById(int id);

    public void deleteHotel(int id);

    public void editHotel(int id, Hotel hotel);

    public List<Hotel> getAllHotelesByCiudad(int idCiudad);
}
