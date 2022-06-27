package com.amirkenesbay.eshop.service;

import com.amirkenesbay.eshop.entity.Product;
import com.amirkenesbay.eshop.exceptions.ProductNotFoundException;
import com.amirkenesbay.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product get(Long id) throws ProductNotFoundException {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ProductNotFoundException("Не возможно найти товар по id: " + id);
    }

    public void delete(Long id) throws ProductNotFoundException{
        Long count = productRepository.countById(id);
        if(count == null || count == 0){
            throw new ProductNotFoundException("Не возможно найти товар по id: " + id);
        }
        productRepository.deleteById(id);
    }
}
