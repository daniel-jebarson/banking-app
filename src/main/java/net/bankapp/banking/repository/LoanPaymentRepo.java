package net.bankapp.banking.repository;

import net.bankapp.banking.entity.LoanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanPaymentRepo extends JpaRepository<LoanPayment,Integer> {
}
