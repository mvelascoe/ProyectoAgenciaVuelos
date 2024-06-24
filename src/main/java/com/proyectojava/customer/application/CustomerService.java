package com.proyectojava.customer.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.customer.infrastructure.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerRepository.update(customer);
    }

    public Optional<Customer> findCustomerById(String id_cliente){
        return customerRepository.findById(id_cliente);
    }

    public void deleteCustomer(String id_cliente){
        customerRepository.delete(id_cliente);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
}
