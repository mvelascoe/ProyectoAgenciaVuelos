package com.proyectojava.customer.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.customer.adapters.out.CustomerMySQLRepository;
import com.proyectojava.customer.domain.models.Customer;

public class CustomerService {
    private final CustomerMySQLRepository customerMySQLRepository;

    public CustomerService(CustomerMySQLRepository customerMySQLRepository) {
        this.customerMySQLRepository = customerMySQLRepository;
    }

    public void createCustomer(Customer customer){
        customerMySQLRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerMySQLRepository.update(customer);
    }

    public Optional<Customer> findCustomerById(String id_cliente){
        return customerMySQLRepository.findById(id_cliente);
    }

    public void deleteCustomer(String id_cliente){
        customerMySQLRepository.delete(id_cliente);
    }

    public List<Customer> findAllCustomer(){
        return customerMySQLRepository.findAll();
    }
}
