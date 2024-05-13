package com.coffee.cafe.Service;

import com.coffee.cafe.Repository.ProductRepository;
import com.coffee.cafe.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
