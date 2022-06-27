package com.amirkenesbay.eshop.service;

import com.amirkenesbay.eshop.entity.Product;
import com.amirkenesbay.eshop.entity.Value;
import com.amirkenesbay.eshop.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueService {
    @Autowired
    private ValueRepository valueRepository;

    public List<Value> listAll(){
        return valueRepository.findAll();
    }
}
