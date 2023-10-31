package com.ashir.reservations.service;

import com.ashir.reservations.model.Customer;
import com.ashir.reservations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        if (customer.getDocument().matches("\\d{5,10}")){
            if (customer.getFirstName()!=null){
                if (customer.getLastName()!=null){
                    return customerRepository.save(customer);
                }
            }
        }
        throw new RuntimeException();
    }

    public Optional<Customer> getCustomer(String document){
        return customerRepository.findById(document);
    }

    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer updateCustomer(String document, Customer customer){
        Customer customerToUpdate = getCustomer(document).orElse(null);

        if (customerToUpdate != null){
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setLastName(customer.getLastName());
            customerToUpdate.setAddress(customer.getAddress());
            customerToUpdate.setAge(customer.getAge());
            customerToUpdate.setEmail(customer.getEmail());
            return customerRepository.save(customerToUpdate);
        }
        throw new RuntimeException();
    }

    public void deleteCustomer(String document){
        Customer customer = customerRepository.findById(document).orElse(null);

        if (customer != null){
            customerRepository.deleteById(document);
            return;
        }
        throw new RuntimeException();
    }
}
