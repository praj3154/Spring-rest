package com.jspider.cardekhoAPI.reposistry;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.cardekhoAPI.pojo.Car;

@Repository
public class CarRepo {
	
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
	  
	  
	  public Car addCar( Car car) {
		  
		  
		  openConnection();
		  
		  entityTransaction.begin();
		  
		  entityManager.persist(car);
		  entityTransaction.commit();
		  closeConnection();
		
		  
		  return car;
		  
	}
	  
	  public Car  deleteCar( int carId) {
		  
		  openConnection();
		  entityTransaction.begin();
		  Car car = entityManager.find(Car.class, carId);
		  entityManager.remove(car);
		  entityTransaction.commit();
		  closeConnection();
		
		  
		  return car;
	}
	  
	  public List<Car> findAllcar() {
		  
		  openConnection();
		  entityTransaction.begin();
		  Query query = entityManager.createQuery("Select car From  Car car");
		  @SuppressWarnings("unchecked")
		List<Car> cars = query.getResultList();
		  entityTransaction.commit();
		  closeConnection();
		  
		  return cars;
		
	}
	  
	  public Car updateCar( Car car ) {
		  openConnection();
		  Car carToUpdated = entityManager.find(Car.class ,  car.getId());
		  entityTransaction.begin();
		  if (carToUpdated != null) {
			  carToUpdated.setName(car.getName());
			  carToUpdated.setBrand(car.getBrand());
			  carToUpdated.setPrice(car.getPrice());
			  entityManager.persist(carToUpdated);
			  entityTransaction.commit();
			  closeConnection();
			
		}
		 
		  
		  return carToUpdated;
		
		  
		
		  
		
		
	}

}
