package ie.atu.loansservice.service;

import ie.atu.loansservice.errorHandling.DuplicateExceptionHandling;
import ie.atu.loansservice.model.Loan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final List<Loan> loanList = new ArrayList<>();

    // Defensive Copy of Loan List
    public List<Loan> getLoanList() { return new ArrayList<>(loanList); }

    // Search By ID
    public Optional<Loan> getLoanByID(String id){
        for (Loan loan : loanList){
            if(loan.getLoanId().equals(id)){
                return Optional.of(loan);
            }
        }
        return Optional.empty();
    }

    public Loan createLoan(Loan loan) {
        if(getLoanByID(loan.getLoanId()).isPresent()){
            throw new DuplicateExceptionHandling("Loan: " + loan.getLoanId() + " Already Exists");
        }
        loanList.add(loan);
        return loan;
    }
}
