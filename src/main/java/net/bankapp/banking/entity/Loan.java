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
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Integer loanId;

    @NotBlank(message = "Loan type is required")
    @Size(max = 20, message = "Loan type must be less than 20 characters")
    @Column(name = "loan_type", length = 20, nullable = false)
    private String loanType;

    @NotNull(message = "Loan amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Loan amount must be greater than 0")
    @Column(name = "loan_amount", nullable = false)
    private Double loanAmount;

    @NotNull(message = "Interest rate is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Interest rate must be greater than 0")
    @Column(name = "interest_rate", nullable = false)
    private Double interestRate;

    @NotNull(message = "Term is required")
    @Min(value = 1, message = "Term must be at least 1 month")
    @Column(name = "term", nullable = false)
    private Integer term;

    @NotNull(message = "Start date is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @NotBlank(message = "Status is required")
    @Size(max = 20, message = "Status must be less than 20 characters")
    @Column(name = "status", length = 20, nullable = false)
    private String status;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanPayment> loanPayments = new ArrayList<>();
}