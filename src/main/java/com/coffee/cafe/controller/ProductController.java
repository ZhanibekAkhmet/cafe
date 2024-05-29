package com.coffee.cafe.controller;

import com.coffee.cafe.dto.ProductDto;
import com.coffee.cafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value = "/product")
    public String listPage(Model model) {
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping(value = "/product/new")
    public String newPage() {
        return "form";
    }

    @GetMapping(value = "/product/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        ProductDto product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "form";
    }

    @PostMapping(value = "/save")
    public String saveProduct(ProductDto product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/product/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

}
