package com.jspider.cardekhoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.cardekhoAPI.pojo.Car;
import com.jspider.cardekhoAPI.reponse.ResponseStructure;
import com.jspider.cardekhoAPI.service.CarService;

@RestController
public class CarContrller {
	@Autowired
	CarService carsevice;
	
	@PostMapping(path = "car")
	public ResponseEntity<Car> addCar( @RequestBody  Car  car ) {
	
		Car addedCar = carsevice.addCar(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedCar);
		
	}
	
	
	@DeleteMapping ( path = "/car")
	public ResponseEntity<Car> carDeleted(@RequestParam (name = "carId") int carId) {
		
		Car deletedcar = carsevice.carDeleted(carId);
		
		return ResponseEntity.status(HttpStatus.OK).body(deletedcar);
		
		
	}
	@GetMapping(path = "/car")
	public ResponseEntity<ResponseStructure<List<Car>>> findAllCars() {
		List< Car> cars = carsevice.findAllCar();
		ResponseStructure< List<Car>> responseStructure = new ResponseStructure<List<Car>>();
		if ( cars != null) {
		responseStructure.setMassage("Cars found");
		responseStructure.setData(cars);
		responseStructure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			
			responseStructure.setMassage("car not found");
			responseStructure.setData(cars);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure ,HttpStatus.NOT_FOUND);
		}
		
	
		
	}
	@PutMapping(path = "/car")
	
	public ResponseEntity<ResponseStructure<Car>> UpdateCar( @RequestBody Car car) {
		
		Car carUpdated =  carsevice.updateCar(car);
		ResponseStructure< Car> responseStructure = new ResponseStructure<Car>();
		if(carUpdated != null ) {
		
			responseStructure.setMassage("Car Updated");
			responseStructure.setData(carUpdated);
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			 return new ResponseEntity<ResponseStructure<Car>>(responseStructure , HttpStatus.ACCEPTED);
			
			
			
		}
		else {
			responseStructure.setMassage("Car Not  Updated");
			responseStructure.setData(carUpdated);
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			 return new ResponseEntity<ResponseStructure<Car>>(responseStructure , HttpStatus.BAD_REQUEST);
			
		}
		
	}

}