package com.example.accountRegistry.service;

import com.example.accountRegistry.entity.product;
import com.example.accountRegistry.repositry.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productservice {
    @Autowired
    private productrepository productRepo;
    public void saveProducts(product b){
        productRepo.save(b);
    }
    public List<product> products(){
        return productRepo.findAll();
    }

    public List<product> listAllP(String kw){
        if(kw != null){
            return productRepo.search(kw);
        }
        return productRepo.findAll();
    }
}
