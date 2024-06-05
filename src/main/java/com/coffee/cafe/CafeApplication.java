package com.coffee.cafe;

import com.coffee.cafe.service.ProductService;
import com.coffee.cafe.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CafeApplication{

	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}

	public void run(String... args) throws Exception {
	}
}
