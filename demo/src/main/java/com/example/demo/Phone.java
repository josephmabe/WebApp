package com.example.demo;

public class Phone {
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

	public void setMake (String make){
		this.make = make;
	}

	public void setModel(String model){
		this.model = model;
	}

	public void setId(int id){
		this.id = id;
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