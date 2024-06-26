package com.proyectojava.customer.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.customer.infrastructure.CustomerRepository;
import com.proyectojava.documenttype.domain.models.Documenttype;
import com.proyectojava.documenttype.infrastructure.DocumenttypeRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final DocumenttypeRepository documenttypeRepository;
    
    public CustomerService(CustomerRepository customerRepository, DocumenttypeRepository documenttypeRepository) {
        this.customerRepository = customerRepository;
        this.documenttypeRepository = documenttypeRepository;
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

    //TRAER TODOS LOS METODOS DE DOCUMENT TYPE
    public Optional<Documenttype> findDocument(int id_documento){
        return documenttypeRepository.findById(id_documento);
    }

    public List<Documenttype> allDocuments(){
        return documenttypeRepository.findAll();
    }

    public void updateDocument(Documenttype documenttype){
        documenttypeRepository.update(documenttype);
    }
}
