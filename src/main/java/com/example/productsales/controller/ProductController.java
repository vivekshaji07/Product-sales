package com.example.productsales.controller;

import com.example.productsales.entity.Product;
import com.example.productsales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return productService.getAllProducts(page, size);
	}

	@GetMapping("retreive/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("save")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("update/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
		return productService.updateProduct(id, productDetails);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/revenue/total")
	public double getTotalRevenue() {
		return productService.getTotalRevenue();
	}

	@GetMapping("/revenue/{productId}")
	public double getRevenueByProduct(@PathVariable int productId) {
		return productService.getRevenueByProduct(productId);
	}
}
