package com.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	private String ratingId;          // Unique ID for rating (UUID recommended)
	private String userId;             // Which user gave this rating
	private String hotelId;            // Which hotel this rating is for
	private int rating;                 // Rating (e.g., 1 to 5)
	private String feedback;  
	private Hotel hotel;
}
