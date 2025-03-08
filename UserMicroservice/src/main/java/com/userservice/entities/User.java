package com.userservice.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USR_ID")
	private Integer userId; // Unique ID for user (UUID recommended)

	@Column(name = "USR_NAME", nullable = false)
	private String name; // User's full name

	@Column(name = "USR_EMAIL", nullable = false)
	private String email; // Contact email

	@Column(name = "USR_PNO")
	private Long phoneNumber; // Contact number

	@Column(name = "USR_CITY")
	private String city; // Optional, user address

	@Transient   					// This tells Hibernate "ignore this field for DB mapping"
	private List<Rating> ratings;   // This will be manually filled later
}
