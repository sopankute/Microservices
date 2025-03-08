package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelServices hotelService;
	
	public HotelController(HotelServices hotelService) {
		this.hotelService = hotelService;
	}
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel newHotel = hotelService.createHotel(hotel);
		return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		List<Hotel> allHotel = hotelService.getAll();
		return ResponseEntity.ok(allHotel);
	}
}
