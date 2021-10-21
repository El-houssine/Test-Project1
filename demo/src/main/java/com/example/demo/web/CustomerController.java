package com.example.demo.web;

import com.example.demo.entities.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/signup")
    public String showSignUpForm(Customer customer) {
        return "add-customer";
    }

    @GetMapping(path = "/index")
    public String showCustomerList(Model model) {
        model.addAttribute("customers", customerRepo.findAll());
        return "index";
    }

    @PostMapping(path = "/addCustomer")
    @ResponseBody
    public String addCustomer(@RequestBody Customer customer, Model model) {
        customerRepo.save(customer);
        return "redirect:/index";
    }
}
