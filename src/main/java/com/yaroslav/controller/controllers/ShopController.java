package com.yaroslav.controller.controllers;

import com.yaroslav.controller.services.exceptions.InsufficientFundsException;
import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.controller.services.exceptions.NoSuchCustomerException;
import com.yaroslav.controller.services.transaction.TransactionService;
import com.yaroslav.model.transaction.dto.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/computer-shop")
@RequiredArgsConstructor
@Slf4j
public class ShopController {

    private final TransactionService transactionService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> buyComputer(@RequestBody Transaction transaction) throws NoSuchComputerException, InsufficientFundsException, NoSuchCustomerException {

        log.info("Http method - Post, buy computer");
        transactionService.buyComputer(transaction);

        return ResponseEntity.ok().body(transaction);
    }
}
