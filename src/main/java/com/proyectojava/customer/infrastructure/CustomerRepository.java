package com.proyectojava.customer.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.customer.domain.models.Customer;

public interface CustomerRepository {
    void save (Customer customer);
    void update(Customer customer);
    Optional<Customer>findById(String id_cliente);
    void delete(String id_cliente);
    List<Customer>findAll();
}
