package com.amirkenesbay.eshop.controller;

import com.amirkenesbay.eshop.entity.Category;
import com.amirkenesbay.eshop.entity.Product;
import com.amirkenesbay.eshop.exceptions.ProductNotFoundException;
import com.amirkenesbay.eshop.repository.CategoryRepository;
import com.amirkenesbay.eshop.repository.ProductRepository;
import com.amirkenesbay.eshop.service.CategoryService;
import com.amirkenesbay.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CrudController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProductForm(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/products/new")
    public String showNewForm(Model model, Category category) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryService.listAll());
        model.addAttribute("pageTitle", "Добавить новый товар");
        return "create_product";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes ra, Category category) {
        productService.save(product);
        categoryService.save(category);
        ra.addFlashAttribute("message", "Товар добавлен успешно");
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Product product = productService.get(id);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "Изменить товар (ID: " + id + ")");
            return "edit_product";
        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            productService.delete(id);
            ra.addFlashAttribute("message", "Продукт с ID " + id + "удален");
        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/products";
    }
}
