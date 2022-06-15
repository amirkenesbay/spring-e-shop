package com.amirkenesbay.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping(path = "/test")
public class MyController {

    /*@GetMapping(path = "/part_1")
    public String firstPart(Model model) {
        model.addAttribute("message",
                "Text in thymeleaf");

        // Добавляем продукт и считаем общую сумму
        List<Product> products = new ArrayList<>();
        products.add(new Product("PC", "Hp", 155250));
        products.add(new Product("PC", "Dell Pc", 155250));
        products.add(new Product("Laptop", "Lenovo", 250500));
        products.add(new Product("Laptop", "Predator Gaming", 450500));
        products.add(new Product("Phone", "Iphone 12", 420000));
        products.add(new Product("Phone", "Samsung S22", 390000));

        Map<String, Integer> category = new HashMap<>();
        int sum = 0;
        for (Product p : products) {
            if (category.containsKey(p.getCategory())) {
                category.put(p.getCategory(), category.get(p.getCategory()) + p.getPrice());
            } else {
                category.put(p.getCategory(), p.getPrice());
            }
        }
        model.addAttribute("map", category);

        return "test/part1";
    }*/

    @GetMapping(path = "/part_2")
    public String secondPart(
            @RequestParam(name = "first_name") String firstName,
            @RequestParam Integer age, Model model) {

        model.addAttribute("firstName", firstName);
        model.addAttribute("age", age);

        return "test/part2";
    }

    @GetMapping(path = "/part_2_practice")
    public String secondPartPractice(
            @RequestParam(name = "name", required = false) String name,
            Model model) {
        List<String> names = List.of("Alex", "Alim", "Jeff",
                "Hector", "Lena", "Kim", "Lex");
        List<String> result;

        if (name == null) {
            result = names;
        } else {
            result = new ArrayList<>();
            for (String s : names) {
                if (s.startsWith(name)) {
                    result.add(s);
                }
            }
        }

        model.addAttribute("name", result);
        return "test/part_2_practice";
    }
}
