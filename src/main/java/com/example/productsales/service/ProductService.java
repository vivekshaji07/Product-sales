package com.example.productsales.service;

import com.example.productsales.entity.Product;
import com.example.productsales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails);
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            return productRepository.save(product);
        }).orElseGet(() -> {
            productDetails.setId(id);
            return productRepository.save(productDetails);
        });
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public double getTotalRevenue() {
        return productRepository.findAll().stream()
                .flatMap(product -> product.getSales().stream())
                .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
                .sum();
    }

    public double getRevenueByProduct(int productId) {
        return productRepository.findById(productId)
                .map(product -> product.getSales().stream()
                        .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
                        .sum())
                .orElse(0.0);
    }
    
    
}
