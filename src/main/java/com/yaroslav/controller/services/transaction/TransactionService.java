package com.yaroslav.controller.services.transaction;

import com.yaroslav.controller.services.exceptions.InsufficientFundsException;
import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.model.transaction.dto.Transaction;

public interface TransactionService {

    void buyComputer(Transaction transaction) throws InsufficientFundsException, NoSuchCustomerException, NoSuchComputerException;
}
