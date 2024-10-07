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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @NotBlank(message = "Customer type is required")
    @Size(max = 20, message = "Customer type must be less than 20 characters")
    @Column(name = "customer_type", length = 20, nullable = false)
    private String customerType;

    // Relationships
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    private Person person;

    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();
}