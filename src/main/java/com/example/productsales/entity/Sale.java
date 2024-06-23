package com.example.productsales.entity;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Getter
@Setter
public class Sale {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private LocalDate saleDate;
    
    public Sale() {}
    
	public Sale(Long id, Product product, int quantity, LocalDate saleDate) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.saleDate = saleDate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

    // Constructors, Getters and Setters
    
}

