package com.jspider.cardekhoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.cardekhoAPI.pojo.Car;
import com.jspider.cardekhoAPI.pojo.User;
import com.jspider.cardekhoAPI.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping(path = "/user")
	public  ResponseEntity<User> addUser( @RequestBody User user) {
		
		User addedUser  =  userService.addUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
		
	}
	@PatchMapping (path =  "/user")
	public ResponseEntity<User> upadateListForUser(@RequestParam (name = "carId") int carId , @RequestParam (name = "userId") int userId) {
		
		User UpdatedUser = userService.updateCarListForUser(userId, carId);
		if ( UpdatedUser != null ) {
			return ResponseEntity.status(HttpStatus.OK).body(UpdatedUser);
			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(UpdatedUser);
		}
	
	}

}
