package com.coffee.cafe.service;

import com.coffee.cafe.dto.ProductDto;
import com.coffee.cafe.exception.EntityNotFoundException;
import com.coffee.cafe.mapper.ProductMapper;
import com.coffee.cafe.repository.ProductRepository;
import com.coffee.cafe.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public ProductDto getProduct(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Продукт с id = " + id + " не найден")));
    }

    public ProductDto saveProduct(ProductDto product) {
        return productMapper.toDto(productRepository.save(productMapper.toModel(product)));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Продукт с id = " + id + " не найден");
        }
        productRepository.deleteById(id);

    }
}
