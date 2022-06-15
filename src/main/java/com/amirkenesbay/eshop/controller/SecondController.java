package com.amirkenesbay.eshop.controller;

import com.amirkenesbay.eshop.entity.Product;
import com.amirkenesbay.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class SecondController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{number}")
    public String test(@PathVariable(name = "number")
                           Long number, Model model) {

        Product product = productRepository
                .findById(number)
                .orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });

        model.addAttribute("product", product);

        return "test/product";
    }
}
