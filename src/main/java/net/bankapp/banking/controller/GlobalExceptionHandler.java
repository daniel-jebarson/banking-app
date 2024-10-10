package net.bankapp.banking.controller;

import net.bankapp.banking.Error.CustomException;
import net.bankapp.banking.Error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        String errorLine = getStackTraceLine(ex);  // Get detailed error line information
        ErrorResponse errorResponse = new ErrorResponse(
                500,
                "Internal Server Error: " + ex.getMessage()+"\nClass : "+ex.getClass().getSimpleName()+"\n Error in line : "+errorLine

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getStackTraceLine(Throwable ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        if (stackTrace.length > 0) {
            StackTraceElement element = stackTrace[0]; // The first element is usually the error line
            return element.getClassName() + ":" + element.getLineNumber();
        }
        return "Unknown source";
    }

}
