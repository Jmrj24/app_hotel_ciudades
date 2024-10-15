package com.example.hotels_service.service;

import com.example.hotels_service.model.Hotel;
import com.example.hotels_service.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {
    @Autowired
    private IHotelRepository hotelRepo;

    @Override
    public void saveHotel(Hotel hotel) {
        hotelRepo.saveHotel(hotel);
    }

    @Override
    public List<Hotel> getAllHoteles() {
        return hotelRepo.getAllHoteles();
    }

    @Override
    public Hotel getHotelById(int id) {
        return hotelRepo.getHotelById(id);
    }

    @Override
    public void deleteHotel(int id) {
        hotelRepo.deleteHotel(id);
    }

    @Override
    public void editHotel(int id, Hotel hotel) {
        hotelRepo.editHotel(id, hotel);
    }

    @Override
    public List<Hotel> getAllHotelesByCiudad(int idCiudad) {
        List<Hotel> listaHoteles = this.getAllHoteles();
        List<Hotel> listaHotelesCiudad = new ArrayList<>();

        for(Hotel hotel:listaHoteles) {
            if(idCiudad==hotel.getIdCiudad()) {
                listaHotelesCiudad.add(hotel);
            }
        }
        return listaHotelesCiudad;
    }
}
