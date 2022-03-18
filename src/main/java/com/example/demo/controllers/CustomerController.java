package com.example.demo.controllers;


import com.example.demo.entity.Persons;
import com.example.demo.service.CustomersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("customer")
@Controller
public class CustomerController {

    private final CustomersServiceImp customersServiceImp;

    @Autowired
    public CustomerController(CustomersServiceImp customersServiceImp) {
        this.customersServiceImp = customersServiceImp;
    }

    @GetMapping(path = "/details")
    public String customersList(Model model) {

        List<Persons> personList = customersServiceImp.findAll();
        model.addAttribute("personList", personList);

        return "customer/details";
    }

    @GetMapping(path = "/add")
    public String addCustomer(Model model) {

        Persons persons = new Persons();
        model.addAttribute("persons", persons);

        return "customer/addCustomer";
    }

    @PostMapping(path = "/add")
    public String registerClient(@ModelAttribute("persons") Persons persons, BindingResult bresult) {

        if (bresult.hasErrors()) {
            return "client/addCustomers";
        } else {
            customersServiceImp.savePerson(persons);
            return "customer/succes";
        }
    }

    @GetMapping(path = "/edit/{id}")
    public String editClient(@PathVariable Long id, Model model) {

//        Optional<Persons> persons =
        customersServiceImp.findById(id).ifPresent(o -> model.addAttribute("persons", o));
//        model.addAttribute("persons", persons);

        return "customer/editCustomer";
    }

    @PostMapping(path = "/edit/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("persons") Persons persons, Model model) {

        persons.setId(id);
        customersServiceImp.savePerson(persons);

        return "customer/succes";
    }
    @PostMapping(path = "/delete/{id}")
    public String deleteClient(@PathVariable long id, @ModelAttribute("persons") Persons persons, Model model) {

        persons.setId(id);
        customersServiceImp.deletePersons(persons);

        return "customer/succes";
    }
}
