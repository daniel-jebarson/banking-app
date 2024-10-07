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
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @NotBlank(message = "Transaction type is required")
    @Size(max = 20, message = "Transaction type must be less than 20 characters")
    @Column(name = "transaction_type", length = 20, nullable = false)
    private String transactionType;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotNull(message = "Transaction date is required")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "loan_payment_id", referencedColumnName = "loan_payment_id")
    private LoanPayment loanPayment;

    @ManyToOne
    @JoinColumn(name = "related_transaction_id", referencedColumnName = "transaction_id")
    private Transaction relatedTransaction;
}