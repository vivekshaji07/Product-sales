package com.example.productsales.repository;

import com.example.productsales.entity.Sale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
	  List<Sale> findByproduct_id(int productId);
}
