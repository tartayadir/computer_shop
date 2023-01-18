package com.yaroslav.controller.services.transaction.impl;

import com.yaroslav.controller.services.computer.ComputerService;
import com.yaroslav.controller.services.customer.CustomerService;
import com.yaroslav.controller.services.exceptions.InsufficientFundsException;
import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.controller.services.transaction.TransactionService;
import com.yaroslav.model.computer.entity.Computer;
import com.yaroslav.model.customer.entity.Customer;
import com.yaroslav.model.transaction.dto.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final CustomerService customerService;

    private final ComputerService computerService;

    @Override
    public void buyComputer(Transaction transaction) throws InsufficientFundsException, NoSuchCustomerException,
            NoSuchComputerException {

        Customer customer = customerService.findById(transaction.getComputerId());
        Computer computer = computerService.findById(transaction.getComputerId());

        checkPurchase(customer, computer);

        double newBalance = customer.getAccount() - computer.getPrice();
        customer.setAccount(newBalance);

        customerService.update(customer);
    }

    private static void checkPurchase(Customer customer, Computer computer) throws InsufficientFundsException {

        double customerBalance = customer.getAccount();
        double computerPrice = computer.getPrice();

        if (customerBalance - computerPrice < 0) {
            throw new InsufficientFundsException(String.format("User %s cannot buy computer with id %d, " +
                    "because have not quite money.", customer.getName(), computer.getId()));
        }
    }
 }
