package ie.atu.loansservice.repository;

import ie.atu.loansservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByLoanId(String loanId);

    List<Loan> findByDueDateAfter(LocalDate dueDateAfter);

    Loan getByLoanId(String loanId);
}
