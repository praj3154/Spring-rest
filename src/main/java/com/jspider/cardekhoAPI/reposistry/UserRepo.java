package com.jspider.cardekhoAPI.reposistry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspider.cardekhoAPI.pojo.Car;
import com.jspider.cardekhoAPI.pojo.User;

@Repository
public class UserRepo {

	 private EntityManagerFactory entityManagerFactory ;
	 private EntityManager entityManager;
	 private  EntityTransaction entityTransaction;
	 
	  private void openConnection() {
		  
		  entityManagerFactory =  Persistence.createEntityManagerFactory("car");
		  entityManager = entityManagerFactory.createEntityManager();
		  entityTransaction = entityManager.getTransaction();
		  
	  }
	  
	 
	  
	  private void closeConnection () {
		  
		  if (entityManagerFactory != null) {
			  entityManagerFactory.close();
			  
		  }
		  if (entityManager != null) {
			  entityManager.close();
			  
		  }
		  
		  if (entityTransaction != null) {
			  if ( entityTransaction.isActive()) {
				  entityTransaction.rollback();
			  }
			  
		  }
		  
	  }
	  
	  public User addUser( User user) {
		  openConnection();
		  entityTransaction.begin();
		  entityManager.persist(user);
		  entityTransaction.commit();
		  closeConnection();
		  return user;
		  
		  
		
	}
	
	  
	  public User updateCarListForUser( int userId , int carId) {
		  
		  
		  
		  openConnection();
		  
		   User user = entityManager.find(User.class, userId);
		    Car car = entityManager.find(Car.class, carId);
		    
		    if ( user != null && car != null ) {
		    	List<Car> cars = user.getCars();
		    	if ( cars != null ) {
		    		cars.add(car);
		    	}
		    	else {
		    		cars = new ArrayList();
		    		cars.add(car);
		    		
		    	}
		    	
		    	user.setCars(cars);
		    	entityTransaction.begin();
		    	entityManager.persist(user);
		    	entityTransaction.commit();
		    	User updatedUSer = entityManager.find(User.class, userId);
		    
		    	closeConnection();
		    	
		    	  return updatedUSer;
		    	
		    	
		    }
		    
		    else {
		    	return null ;
		    }
		  
		  
		
	}
	
}
