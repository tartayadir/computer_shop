package com.yaroslav.model.transaction.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Transaction implements Serializable {

    private long computerId;

    private long customerId;

    private long computerNumber;
}
