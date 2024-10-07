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
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @NotBlank(message = "Account type is required")
    @Size(max = 20, message = "Account type must be less than 20 characters")
    @Column(name = "account_type", length = 20, nullable = false)
    private String accountType;

    @NotBlank(message = "Account number is required")
    @Size(max = 20, message = "Account number must be less than 20 characters")
    @Column(name = "account_number", length = 20, nullable = false, unique = true)
    private String accountNumber;

    @NotNull(message = "Current balance is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Current balance must be greater than 0")
    @Column(name = "current_balance", nullable = false)
    private Double currentBalance;

    @NotNull(message = "Date opened is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_opened", nullable = false)
    private Date dateOpened;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_closed")
    private Date dateClosed;

    @NotBlank(message = "Account status is required")
    @Size(max = 20, message = "Account status must be less than 20 characters")
    @Column(name = "account_status", length = 20, nullable = false)
    private String accountStatus;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false)
    private Branch branch;

    @ManyToMany
    @JoinTable(
            name = "customer_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();
}