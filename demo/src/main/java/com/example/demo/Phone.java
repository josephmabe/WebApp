package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "models")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String make;
	private String model;

	public Phone() { }
	
	public int getId() {
		return id;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return "Phone{" +
				"id=" + id +
				", make='" + make + '\'' + 
				", model='" + model +'\'' +
				'}';
	}
	
}