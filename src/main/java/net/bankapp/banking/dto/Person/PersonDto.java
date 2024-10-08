package net.bankapp.banking.dto.Person;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonDto {
    private Integer id;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name must be less than 100 characters")
    private String lname;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must be less than 100 characters")
    private String fname;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private Date dob;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    private String number;

    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address must be less than 100 characters")
    private String address;

}
