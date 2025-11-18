package ie.atu.loansservice.controller;

import ie.atu.loansservice.model.Loan;
import ie.atu.loansservice.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/loan")
@RestController
public class LoanController {

    // Constructor Based Dependency Injection
    private final LoanService loanService;
    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    // Get Request to Return List of all Loans
    @GetMapping("/returnAllLoans")
    public ResponseEntity<List<Loan>> getLoanList(){
        return ResponseEntity.ok(loanService.getLoanList());
    }

    @PostMapping
    public ResponseEntity<Loan> create(@Valid @RequestBody Loan loan){
        Loan loanCreated = loanService.createLoan(loan);
        return ResponseEntity
                .created(URI.create("/api/loan" + loanCreated.getLoanId()))
                .body(loanCreated);
    }
}
