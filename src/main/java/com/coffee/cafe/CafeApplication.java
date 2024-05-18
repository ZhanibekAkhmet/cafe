package com.coffee.cafe;

import com.coffee.cafe.service.ProductService;
import com.coffee.cafe.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CafeApplication implements CommandLineRunner {
	private final ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Product product = new Product();
//		product.setName("Latte");
//		product.setDescription("Какой-то кофе");
//		productService.save(product);
//
//		Product product2 = new Product();
//		product2.setName("Kapuchino");
//		product2.setDescription("на основе эспрессо с добавлением в него подогретого вспененного молока");
//		productService.save(product2);
//		System.out.println(productService.findAll());
//
//		Long product2Id = product2.getId();
//		Product editedProduct = productService.findById(product2Id);
//		editedProduct.setDescription("Зкончился, поэтому удаляем");
//		productService.save(editedProduct);
//		System.out.println(productService.findAll());
//
//		productService.delete(editedProduct);
		System.out.println(productService.findAll());
	}
}
