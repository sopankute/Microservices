package com.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOTEL_TBL")
public class Hotel {
	@Column(name = "HTL_ID")
	@Id
	private String hotelId;          // Unique ID for hotel (UUID recommended)
	
	@Column(name = "HTL_NAME")
	private String name;              // Hotel name
	
	@Column(name = "HTL_LOC")
	private String location;          // City/Address of hotel
	
	@Column(name = "HTL_DESC")
	private String description;       // Short description about hotel
}
