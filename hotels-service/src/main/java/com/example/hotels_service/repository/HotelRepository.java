package com.example.hotels_service.repository;

import com.example.hotels_service.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepository implements IHotelRepository {
    List<Hotel> listaHoteles = new ArrayList<>();

    @Override
    public void saveHotel(Hotel hotel) {
        listaHoteles.add(hotel);
    }

    @Override
    public List<Hotel> getAllHoteles() {
        if(listaHoteles.isEmpty()) {
            this.loadHoteles();
        }
        return listaHoteles;
    }

    @Override
    public Hotel getHotelById(int id) {
        return listaHoteles.get(id-1);
    }

    @Override
    public void deleteHotel(int id) {
        listaHoteles.remove(id-1);
    }

    @Override
    public void editHotel(int id, Hotel hotel) {

    }

    public void loadHoteles() {
        listaHoteles.add(new Hotel(1,"Paradise", 5, 1));
        listaHoteles.add(new Hotel(2, "Sunset View", 4, 2));
        listaHoteles.add(new Hotel(3, "Ocean Breeze", 3, 3));
        listaHoteles.add(new Hotel(4, "Mountain Retreat", 4, 1));
        listaHoteles.add(new Hotel(5, "City Lights Inn", 3, 2));
        listaHoteles.add(new Hotel(6, "Riverside Lodge", 4, 3));
        listaHoteles.add(new Hotel(7, "Cozy Cabin Resort", 2, 1));
        listaHoteles.add(new Hotel(8, "Luxury Haven", 5, 2));
        listaHoteles.add(new Hotel(9, "Historic Grand Hotel", 4, 3));
        listaHoteles.add(new Hotel(10, "Tranquil Gardens", 3, 1));
    }
}
