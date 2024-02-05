package com.user.service.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.services.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User u){
		User u1=service.saveUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);		
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasRole('ROLE_ADMIN')")
	@PostMapping("/{id}")
	@CircuitBreaker(name="Rating-Hotel-Breaker",fallbackMethod = "fallback1")
	@RateLimiter(name="RateLimiter", fallbackMethod = "ratelimitfallback1")
	public ResponseEntity<Rating> addRating(@PathVariable int id, @RequestBody Rating r){
		service.addRating(r);
		return ResponseEntity.ok(r);  
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	@CircuitBreaker(name="Rating-Hotel-Breaker",fallbackMethod = "fallback")
	@RateLimiter(name="RateLimiter", fallbackMethod = "ratelimitfallback")
	public ResponseEntity<User> get(@PathVariable("id") int id){
		User u1=service.getuser(id);
	//	System.out.println(u1);
		return ResponseEntity.ok(u1);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasRole('ROLE_ADMIN')")
	@GetMapping
	@CircuitBreaker(name="Rating-Hotel-Breaker2",fallbackMethod = "fallback2")
	@RateLimiter(name="RateLimiter", fallbackMethod = "ratelimitfallback2")
	public ResponseEntity<List<User>> getAll(){
		List<User>l=service.getall();
		return ResponseEntity.ok(l);
	}
	
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	@CircuitBreaker(name="Rating-Hotel-Breaker",fallbackMethod = "fallback1")
	@RateLimiter(name="RateLimiter", fallbackMethod = "ratelimitfallback1")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating r, @PathVariable int id){
		User u=service.getuser(id);
		List<Rating> ratelist=u.getRating();
		for(Rating r1: ratelist) {
			if(r1.getRateId()==r.getRateId()) {
				r1.setHotelId(r.getHotelId());
				r1.setRatings(r.getRatings());
				r1.setFeedback(r.getFeedback());
				return ResponseEntity.ok(r);
			}
		}
		return ResponseEntity.notFound().eTag("Ratings not found for UserId: "+u.getUserId()+" with RateId: "+r.getRateId()).build();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	@CircuitBreaker(name="Rating-Hotel-Breaker",fallbackMethod = "fallback")
	@RateLimiter(name="RateLimiter", fallbackMethod = "ratelimitfallback")
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		return ResponseEntity.ok(service.delete(id));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/rating/{id}")
	@CircuitBreaker(name="Rating-Hotel-Breaker",fallbackMethod = "fallback1")
	@RateLimiter(name="RateLimiter", fallbackMethod = "ratelimitfallback1")
	public ResponseEntity<Rating> deleteRating(@PathVariable int id){
		return ResponseEntity.ok(service.deleteByRateId(id));
	}
	
	public ResponseEntity<User> fallback(int id, Exception e){
		e.printStackTrace();
		User u1=new User();
		u1.setName("Dummy");
		u1.setEmail("Dummy@gmail.com");
		u1.setRating(null);
		u1.setUserId(-1);
		return new ResponseEntity<>(u1,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Rating> fallback1(int id, Exception e){
		Rating r1=new Rating();
		r1.setFeedback(null);
		r1.setHotel(null);
		r1.setHotelId(-1);
		r1.setRateId(-1);
		r1.setRatings(null);
		r1.setUserId(-1);		
		return new ResponseEntity<>(r1,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<List<User>> fallback2(Exception e){
		List<User> l1=new ArrayList<User>();
		l1.add(new User(-1,"DUMMY","DUMMY",null));
		return new ResponseEntity<>(l1,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Rating> ratelimitfallback1(int id, Exception e){
		Rating r1=new Rating();
		r1.setFeedback(null);
		r1.setHotel(null);
		r1.setHotelId(-1);
		r1.setRateId(-1);
		r1.setRatings(null);
		r1.setUserId(-1);	
		return new ResponseEntity<Rating>(r1,HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
	
	public ResponseEntity<User> ratelimitfallback(int id, Exception e){
		e.printStackTrace();
		User u1=new User();
		u1.setName("Dummy");
		u1.setEmail("Dummy@gmail.com");
		u1.setRating(null);
		u1.setUserId(-1);	
		return new ResponseEntity<User>(u1,HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
	
	public ResponseEntity<List<User>> ratelimitfallback2(Exception e){
		List<User> l1=new ArrayList<User>();
		l1.add(new User(-1,"DUMMY","DUMMY",null));
		return new ResponseEntity<List<User>>(l1,HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
}
