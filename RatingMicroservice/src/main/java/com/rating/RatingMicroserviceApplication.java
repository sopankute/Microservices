package com.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingMicroserviceApplication.class, args);
		
		System.out.println("\nRatingMicroserviceApplication.main()"+"|Rating Application Started Sucessfully...\n");
	}

}
