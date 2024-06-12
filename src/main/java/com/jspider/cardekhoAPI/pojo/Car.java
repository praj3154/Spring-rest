package com.jspider.cardekhoAPI.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CarApi")
public class Car {
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private int id;
   @Column(unique = true )
	private String name;
	private String brand;
	private double price;
	

}
