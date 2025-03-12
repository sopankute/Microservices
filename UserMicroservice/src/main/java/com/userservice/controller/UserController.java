package com.userservice.controller;

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

import com.userservice.entities.User;
import com.userservice.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.saveUser(user);
		System.out.println("UserController.createUser()" + "Created User ::" + createdUser);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingServiceBreaker", fallbackMethod = "ratingServiceFallBack")
//	@Retry(name = "ratingServiceRetry", fallbackMethod = "ratingServiceFallBack")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "rateLimitFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable Integer userId) {
		
		User user = userService.getUser(userId);	// calling External services
		return new ResponseEntity<User>(user, HttpStatus.OK); 
	}
	
	
	public ResponseEntity<User> rateLimitFallback(Integer userId, Exception ex){
		
		User user = User.builder().name("Dummy")
						.email("dummy@gmail.com").city("Dummy")
						.phoneNumber(null).build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {

		List<User> allUsers = userService.getAllUsers();

		return ResponseEntity.ok(allUsers);

	}

}
