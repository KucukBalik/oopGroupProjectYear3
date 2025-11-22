package ie.atu.loansservice.service;

import ie.atu.loansservice.errorHandling.DuplicateExceptionHandling;
import ie.atu.loansservice.errorHandling.NotFoundException;
import ie.atu.loansservice.feign.client.UserClient;
import ie.atu.loansservice.model.Loan;
import ie.atu.loansservice.model.UserDTO;
import ie.atu.loansservice.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final UserClient userClient;
    private final LoanRepository loanRepository;
    public LoanService(UserClient userClient, LoanRepository loanRepository) {
        this.userClient = userClient;
        this.loanRepository = loanRepository;
    }

    // Defensive Copy of Loan List
    public List<Loan> getLoanList() { return loanRepository.findAll(); }

    // Search By ID
    public Loan getLoanByID(String loanId){
        return loanRepository.findByLoanId(loanId).orElseThrow(() -> new NotFoundException(loanId + " not found"));
    }

    public List<Loan> getDueLoans(){
        return loanRepository.findByDueDateAfter(LocalDate.now());
    }

    public Loan createLoan(Loan loan) {
        if(loanRepository.findByLoanId(loan.getLoanId()).isPresent()){
            throw new DuplicateExceptionHandling(loan.getLoanId() + " Already Exists");
        }
        UserDTO user = userClient.getUserById(loan.getUserId());
        if(user == null){
            throw new NotFoundException(loan.getUserId() + " doesnt Exist");
        }
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusWeeks(1));
        loan.setReminderDate(LocalDate.now().plusWeeks(1).minusDays(1));
        return loanRepository.save(loan);
    }

    // Add Update

    // Add Delete
}
