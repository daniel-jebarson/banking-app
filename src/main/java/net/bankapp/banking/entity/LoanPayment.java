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
@Table(name = "loan_payments")
public class LoanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_payment_id")
    private Integer loanPaymentId;

    @NotNull(message = "Scheduled payment date is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "scheduled_payment_date", nullable = false)
    private Date scheduledPaymentDate;

    @NotNull(message = "Payment amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Payment amount must be greater than 0")
    @Column(name = "payment_amount", nullable = false)
    private Double paymentAmount;

    @NotNull(message = "Principal amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Principal amount must be greater than 0")
    @Column(name = "principal_amount", nullable = false)
    private Double principalAmount;

    @NotNull(message = "Interest amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Interest amount must be greater than 0")
    @Column(name = "interest_amount", nullable = false)
    private Double interestAmount;

    @DecimalMin(value = "0.0", inclusive = false, message = "Paid amount must be greater than 0")
    @Column(name = "paid_amount")
    private Double paidAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "paid_date")
    private Date paidDate;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id", nullable = false)
    private Loan loan;

    @OneToMany(mappedBy = "loanPayment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();
}