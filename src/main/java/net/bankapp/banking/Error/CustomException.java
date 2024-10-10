package net.bankapp.banking.Error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException{
    private Integer status;
    private String message;

    public  CustomException(Integer status,String message){
        super(message);
        this.status = status;
        this.message = message;
    }
}
