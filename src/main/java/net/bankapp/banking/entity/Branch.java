package net.bankapp.banking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branches")
public class Branch  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @NotBlank(message = "Branch name is required")
    @Size(max = 100, message = "Branch name must be less than 100 characters")
    @Column(name = "branch_name", length = 100, nullable = false, unique = true)
    private String branchName;

    @NotBlank(message = "Branch code is required")
    @Size(max = 10, message = "Branch code must be less than 10 characters")
    @Column(name = "branch_code", length = 10, nullable = false, unique = true)
    private String branchCode;

    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address must be less than 100 characters")
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    // Relationships
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    // Constructor with parameters
    public Branch(String branchName, String branchCode, String address, String phoneNumber) {
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Constructor with parameters
    public Branch(Integer branchId,String branchName, String branchCode, String address, String phoneNumber) {
        this.branchId=branchId;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}