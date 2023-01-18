package com.yaroslav.model.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ErrorMassageResponse implements Serializable {

    private String error_message;
}
