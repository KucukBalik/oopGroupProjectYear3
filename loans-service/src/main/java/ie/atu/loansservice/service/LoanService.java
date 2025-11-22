package ie.atu.loansservice.service;

import ie.atu.loansservice.errorHandling.DuplicateExceptionHandling;
import ie.atu.loansservice.errorHandling.NotFoundException;
import ie.atu.loansservice.feign.client.UserClient;
import ie.atu.loansservice.model.Loan;
import ie.atu.loansservice.model.UserDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final UserClient userClient;

    public LoanService(UserClient userClient) {
        this.userClient = userClient;
    }

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
            throw new DuplicateExceptionHandling(loan.getLoanId() + " Already Exists");
        }
        UserDTO user = userClient.getUserById(loan.getUserId());
        if(user == null){
            throw new NotFoundException(loan.getUserId() + " doesnt Exist");
        }
        loan.setLoanDate(LocalDate.now());
        loanList.add(loan);
        return loan;
    }
}
