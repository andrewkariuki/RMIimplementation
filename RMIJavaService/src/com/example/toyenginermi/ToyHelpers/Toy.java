package com.example.toyenginermi.ToyHelpers;

public class Toy {
	private int id;
	private String name;
	private double price;
	private int quantity;
	
	public Toy(){}
	
	public Toy(String name, double price,int quantity) {
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
