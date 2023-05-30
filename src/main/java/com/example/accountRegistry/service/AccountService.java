package com.example.accountRegistry.service;

import com.example.accountRegistry.entity.account;

import com.example.accountRegistry.repositry.accountrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private accountrepository aRepo;
    public void save(account a){
        aRepo.save(a);
    }
    public List<account> accounts(){
        return aRepo.findAll();
    }
    public account getAccountID(int id){
        return aRepo.findById(id).get();
    }

    public void deleteByID(int id){
        aRepo.deleteById(id);
    }
    public List<account> listAll(String keyword){
        if(keyword != null){
            return aRepo.search(keyword);
        }
        return aRepo.findAll();
    }


}
