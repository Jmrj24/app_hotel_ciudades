package com.example.hotels_service.repository;

import com.example.hotels_service.model.Hotel;

import java.util.List;

public interface IHotelRepository {
    public void saveHotel(Hotel hotel);

    public List<Hotel> getAllHoteles();

    public Hotel getHotelById(int id);

    public void deleteHotel(int id);

    public void editHotel(int id, Hotel hotel);
}
