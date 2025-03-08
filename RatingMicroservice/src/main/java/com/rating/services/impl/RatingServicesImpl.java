package com.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repositories.RatingRepo;
import com.rating.services.RatingServices;

@Service
public class RatingServicesImpl implements RatingServices{

	@Autowired
	private RatingRepo ratingRepo;
	
	public RatingServicesImpl(RatingRepo ratingRepo) {
		this.ratingRepo = ratingRepo;
	}
	
	@Override
	public Rating create(Rating rating) {
		System.out.println("RatingServicesImpl.create() "+"| From Controller | rating::"+rating);
		String ratingID = UUID.randomUUID().toString();
		rating.setRatingId(ratingID);
		Rating newRating = ratingRepo.save(rating);
		
		System.out.println("RatingServicesImpl.create()"+"|newRating::"+newRating);
		return newRating;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> allRatings = ratingRepo.findAll();
		return allRatings;
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		List<Rating> ratingsByUserId = ratingRepo.findByUserId(userId);
		return ratingsByUserId;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		List<Rating> raingsByHotelId = ratingRepo.findByHotelId(hotelId);
		return raingsByHotelId;
	}
	
	
	
	
}
