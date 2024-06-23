package com.example.productsales.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Getter
@Setter
public class Sale {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
    private LocalDate saleDate;
    
    public Sale() {}
    
	public Sale(int id, Product product, int quantity, LocalDate saleDate) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.saleDate = saleDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
    
}

