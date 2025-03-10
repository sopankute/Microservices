package com.userservice.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PutExchange;

import com.userservice.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingServiceClient {

	@GetMapping
	List<Rating> getAllRatings();
	
	@GetMapping("/{ratingId}")
	Rating getRatingById(@PathVariable String ratingId);
	
	@PostMapping
	Rating createRating(@RequestBody Rating rating);
	
	@PutMapping("/{ratingId}")
	Rating updateRating(@PathVariable String ratingId, @RequestBody Rating rating);
	
	@DeleteMapping("/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
	
}
