package net.bankapp.banking.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private Integer status;
    private String message;

}