package com.jspider.cardekhoAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jspider.cardekhoAPI.pojo.Car;
import com.jspider.cardekhoAPI.reposistry.CarRepo;

@Service
public class CarService {
	@Autowired
	CarRepo carrepo;
	
	public Car addCar(Car car) {
		
       return carrepo.addCar(car);
		
		
		
		
		
	}
	
	
	public Car carDeleted(int carId) {
		
	       return carrepo.deleteCar(carId);
			
			
			}
	
	public List<Car> findAllCar() {
		
		return carrepo.findAllcar();
		
	}
	
	public Car  updateCar(Car car) {
		return  carrepo.updateCar(car);
		
		
		

	}

}
