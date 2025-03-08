package com.userservice.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.external.services.HotelServiceClient;
import com.userservice.repositories.UserRepo;
import com.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepo userRepo;
	
	@Autowired
	private HotelServiceClient hotelServiceClient;
	
	@Autowired
	private RestTemplate restTemplate;

	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User saveUser(User user) {

		User createdUser = userRepo.save(user);
		System.out.println("UserServiceImpl.createUser()" + "|createdUser::" + createdUser);

		return createdUser;
	}

	@Override
	public User updateUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(Integer userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(" user not found with given ID : " + userId));
		
//		http://localhost:8082/ratings/users/52  :  Ratings By User ID
		
		Rating[] userRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		System.out.println("UserServiceImpl.getUser()"+"| userRatings : "+userRatings);
		
		List<Rating> ratingList = Arrays.stream(userRatings).toList();
		
		ratingList.stream().map(rating->{
//			http://localhost:8081/hotels/6ee1ca20-b9f8-4c5d-8acd-255f65ad8e0a
			
//			By Using RestTemplate
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			Hotel hotel = forEntity.getBody();
			
//			Using Feign Client
			Hotel hotel = hotelServiceClient.getHotel(rating.getHotelId());			
			rating.setHotel(hotel);
			
			System.out.println("UserServiceImpl.getUser()"+"|hotel : "+rating);
			
			return rating;
		}).collect(Collectors.toList());
		
		
		user.setRatings(ratingList);
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = userRepo.findAll();

		return users;
	}

}
