package com.amirkenesbay.eshop.service;

import com.amirkenesbay.eshop.entity.Option;
import com.amirkenesbay.eshop.entity.Product;
import com.amirkenesbay.eshop.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public List<Option> listAll(){
        return optionRepository.findAll();
    }
}
