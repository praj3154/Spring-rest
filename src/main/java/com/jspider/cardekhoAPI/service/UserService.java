package com.jspider.cardekhoAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.cardekhoAPI.pojo.User;
import com.jspider.cardekhoAPI.reposistry.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userrepo;
	
	public User  addUser( User user) {
		return userrepo.addUser(user);
		
	}
	
	public User updateCarListForUser( int userId , int carId ) {
		return userrepo.updateCarListForUser(userId, carId);
		
	}
	
	
}

