package com.hotel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositroy.HotelRepo;
import com.hotel.services.HotelServices;

@Service
public class HoteServicesImpl implements HotelServices {
	
	@Autowired
	private HotelRepo hotelRepo;
	
	public HoteServicesImpl(HotelRepo hotelRepo) {
		this.hotelRepo = hotelRepo;
	}

	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		Hotel newHotel = hotelRepo.save(hotel);
		return newHotel;
	}

	@Override
	public Hotel getHotel(String hotelId) {
		Optional<Hotel> hotel = hotelRepo.findById(hotelId);
		return hotel.orElseThrow(()-> new ResourceNotFoundException("Hotel Not found with Id ::"+hotelId));
	}

	@Override
	public List<Hotel> getAll() {
		List<Hotel> allHotels = hotelRepo.findAll();
		return allHotels;
	}
	
	
	
	
}
