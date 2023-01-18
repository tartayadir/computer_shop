package com.yaroslav.controller.services.customer.impl;

import com.yaroslav.controller.services.customer.CustomerService;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.model.customer.entity.Customer;
import com.yaroslav.model.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) throws NoSuchCustomerException {
        if (id == null){
            throw new IllegalArgumentException("Id cannot be null");
        }

        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchCustomerException(format("Cannot find car with id %d", id)));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) throws NoSuchCustomerException {

        if (id == null){
            throw new IllegalArgumentException("Id cannot be null");
        }

        customerRepository.delete(customerRepository.findById(id).orElseThrow(
                () -> new NoSuchCustomerException(format("Cannot find car with id %d", id))));
    }

    @Override
    public Customer update(Customer customer) throws NoSuchCustomerException {

        if (customer.getId() == null){
            throw new IllegalArgumentException("Id cannot be null");
        }

        Long id = customer.getId();

        customerRepository.findById(id).orElseThrow(
                () -> new NoSuchCustomerException(format("Cannot find car with id %d", id)));

        return customerRepository.save(customer);
    }
}
