package com.rating.services;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingServices {
	
	Rating create(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingByUserId(Integer userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
}
