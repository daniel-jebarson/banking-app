package net.bankapp.banking.dto.Branch;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchDto {

    @NotBlank(message = "Branch name is required")
    @Size(max = 100, message = "Branch name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Branch code is required")
    @Size(max = 10, message = "Branch code must be less than 10 characters")
    private String code;

    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address must be less than 100 characters")
    private String address;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be less than 20 characters",min =10)
    private String number;

}
