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
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @NotBlank(message = "Position is required")
    @Size(max = 20, message = "Position must be less than 20 characters")
    @Column(name = "position", length = 20, nullable = false)
    private String position;

    // Relationships
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();
}
