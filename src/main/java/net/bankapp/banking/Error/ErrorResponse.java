package net.bankapp.banking.Error;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private String message;

}