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
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name must be less than 100 characters")
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must be less than 100 characters")
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than 100 characters")
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address must be less than 100 characters")
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    // Relationships
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Customer customer;

    public Person( String lname,String fname, String email, Date dob,  String number,String address) {
        this.firstName=fname;
        this.lastName=lname;
        this.email=email;
        this.dateOfBirth=dob;
        this.phoneNumber=number;
        this.address=address;
    }
}