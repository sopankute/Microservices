package com.rating.controller;

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

import com.rating.entities.Rating;
import com.rating.services.RatingServices;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingServices ratingService;
	
	public RatingController(RatingServices ratingService) {
		this.ratingService = ratingService;
	}
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		System.out.println("RatingController.createRating()"+"|Requested rating::"+rating);
		Rating newRating = ratingService.create(rating);
		System.out.println("RatingController.createRating()"+"|Sending to Service | newRating::"+newRating);
		return new ResponseEntity<Rating>(newRating, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> allRatings = ratingService.getAllRatings();
		return ResponseEntity.ok(allRatings);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId){
		List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingByUserId);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingByHotelId);
	}
	
}
