package com.example.accountRegistry.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import com.example.accountRegistry.entity.account;
import com.example.accountRegistry.entity.product;
import com.example.accountRegistry.service.AccountService;
import com.example.accountRegistry.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class AccountController {
@Autowired
private productservice product;

    @Autowired
    private AccountService service;

    @GetMapping("/homepage")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/account_register")
    public String accountRegister(){
        return "account_register";
    }

    @GetMapping("/product_register")
    public String productRegister(){
        return "product_register";
    }

    @GetMapping("/accounts")
    public ModelAndView accounts(){
        List<account> list= service.accounts();
      //  ModelAndView m = new ModelAndView();
     //   m.setViewName("accounts");
     //   m.addObject("account", list);
        return new ModelAndView("accounts", "account", list);
    } //"booklist"

    @GetMapping("/accountproducts")
    public ModelAndView accountproducts(){
        List<product> list= product.products();
        return new ModelAndView("accountproducts","product", list);
    } // For ModelAndView ((/nameofwebsite), (name of entity (?)), list)

    @PostMapping("/save")
    public String addAccount(@ModelAttribute account a){
        service.save(a);
        return "redirect:/accounts";
    }
    @PostMapping("/saveProducts")
    public String addProduct(@ModelAttribute product b){
        product.saveProducts(b);
        return "redirect:/accountproducts";
    }

    @Autowired
    private AccountService serv;
@RequestMapping("/deleteAcc/{id}")
    public String deleteAcc(@PathVariable("id") int id){
    serv.deleteByID(id);
        return "redirect:/accounts";
    }

    @RequestMapping("/editAccount/{id}")
    public String editAccount(@PathVariable("id") int id, Model model){
    account b = serv.getAccountID(id);
    model.addAttribute("account", b);
    return "accountUpdate";
    }

    @GetMapping("/accounts/")
    public String viewAccounts(Model model, @RequestParam("keyword") String keyword){
        List<account> listAccounts = service.listAll(keyword.trim());
        model.addAttribute("listAccounts", listAccounts);
        model.addAttribute("keyword", keyword);
        return "/accounts";
    }

    @GetMapping("/accountproducts/")
    public String viewProducts(Model model, @Param("kw") String kw){
        List<product> listProduct = product.listAllP(kw); // might receive issue?
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("kw", kw);

        return "/accountproducts";

    }

}
