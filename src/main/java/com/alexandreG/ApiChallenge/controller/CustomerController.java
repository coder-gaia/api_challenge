package com.alexandreG.ApiChallenge.controller;

import com.alexandreG.ApiChallenge.model.Customer;
import com.alexandreG.ApiChallenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> readCustomers() {
        return customerService.readCustomers();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> findCustomerById(@PathVariable("id") Long id) {
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        return customerService.delete(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
}
