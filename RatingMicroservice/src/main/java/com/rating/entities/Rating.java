package com.rating.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "RATING_TBL")
public class Rating {
	
	@Id
	@Column(name = "RATING_ID")
	private String ratingId;          // Unique ID for rating (UUID recommended)
	
	@Column(name = "USER_ID")
	private Integer userId;             // Which user gave this rating
	
	@Column(name = "HOTEL_ID")
	private String hotelId;            // Which hotel this rating is for
	
	@Column(name = "RATING")
	private int rating;                 // Rating (e.g., 1 to 5)
	
	@Column(name = "FEEDBACK")
	private String feedback;           // Optional feedback or review text
}
