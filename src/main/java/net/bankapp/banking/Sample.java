package net.bankapp.banking;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class Sample {
    @GetMapping("")
    public String Sample(){
//        Model from https://vertabelo.com/blog/database-design-for-banking-system/
        return "Hello world";
    }
}
