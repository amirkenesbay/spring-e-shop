package com.amirkenesbay.eshop.service;

import com.amirkenesbay.eshop.entity.Category;
import com.amirkenesbay.eshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAll(){
        return categoryRepository.findAll();
    }
}
