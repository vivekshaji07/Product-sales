package com.example.productsales.service;

import com.example.productsales.entity.Sale;
import com.example.productsales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(int id) {
        return saleRepository.findById(id);
    }

    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public void deleteSale(int id) {
        saleRepository.deleteById(id);
    }
}

