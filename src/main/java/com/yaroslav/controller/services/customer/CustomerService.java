package com.yaroslav.controller.services.customer;

import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.model.customer.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id) throws NoSuchCustomerException;

    Customer save(Customer customer);

    void deleteById(Long id) throws NoSuchCustomerException;

    Customer update(Customer customer) throws NoSuchCustomerException;
}
