package net.bankapp.banking.Mapper;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.Error.ErrorResponse;

public class ErrorMapper {
    public static ErrorResponse CustomExceptionToErrorResponse(CustomException customException){
        return new ErrorResponse(customException.getStatus(),customException.getMessage());
    }
}
