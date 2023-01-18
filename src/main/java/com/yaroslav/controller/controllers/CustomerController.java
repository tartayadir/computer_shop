package com.yaroslav.controller.controllers;

import com.yaroslav.controller.services.customer.CustomerService;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.model.computer.entity.Computer;
import com.yaroslav.model.customer.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCars() {

        log.info("Http method - Get, all customers");
        List<Customer> customers = customerService.findAll();

        return ResponseEntity.ok().body(customers);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws NoSuchCustomerException {

        log.info("Http method - Get, customer with id {}", id);
        Customer customer = customerService.findById(id);

        return ResponseEntity.ok().body(customer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        log.info("Http method - Post, post customer");

        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentContextPath().
                path("/customer").
                toUriString());

        customer = customerService.save(customer);

        return ResponseEntity.created(uri).body(customer);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws NoSuchCustomerException {

        log.info("Http method - Put, update customer with id {}", customer.getId());
        customer = customerService.update(customer);

        return ResponseEntity.ok().body(customer);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> removeCustomer(@PathVariable Long id) throws NoSuchCustomerException {

        log.info("Http method - Delete, delete customer with id {}", id);
        customerService.deleteById(id);


        return ResponseEntity.ok().build();
    }
}
