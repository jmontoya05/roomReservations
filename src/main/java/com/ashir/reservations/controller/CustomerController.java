package com.ashir.reservations.controller;

import com.ashir.reservations.model.Customer;
import com.ashir.reservations.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{document}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable String document){
        return new ResponseEntity<>(customerService.getCustomer(document),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @PutMapping("/{document}")
    private ResponseEntity<Customer> updateCustomer(@PathVariable String document, @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(document, customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{document}")
    private ResponseEntity<String> deleteCustomer(@PathVariable String document){
        customerService.deleteCustomer(document);
        return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
    }
}
