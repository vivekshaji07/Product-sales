package com.example.productsales.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Id;


@Getter
@Setter
@javax.persistence.Entity
public class Product {

    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    @javax.persistence.OneToMany(mappedBy = "product", cascade = javax.persistence.CascadeType.ALL)
    private List<Sale> sales;

	
    public void setName(Product productDetails) {
		// TODO Auto-generated method stub
		
	}
    public Product() {}

	public Product(int id, String name, String description, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.sales = sales;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
    // Constructors, Getters and Setters 
    
}
