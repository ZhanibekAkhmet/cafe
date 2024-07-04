package com.coffee.cafe.mapper;

import com.coffee.cafe.dto.ProductDto;
import com.coffee.cafe.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toModel(ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> productList);
    List<Product> toModelList(List<ProductDto> productList);
}
