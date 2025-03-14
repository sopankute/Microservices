package com.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServiceClient {
	
	@GetMapping("/hotels/{hotelId}")
	Hotel getHotel(@PathVariable() String hotelId);
	
}
