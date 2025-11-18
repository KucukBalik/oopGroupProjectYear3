package ie.atu.loansservice.controller;

import ie.atu.loansservice.errorHandling.NotFoundException;
import ie.atu.loansservice.model.Loan;
import ie.atu.loansservice.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable String id){
        Optional<Loan> loanFound = loanService.getLoanByID(id);
        if(loanFound.isPresent()){
            return ResponseEntity.ok(loanFound.get());
        }
        else{
            throw new NotFoundException("Loan: " + id + " Doesnt Exist");
        }
    }

    @PostMapping
    public ResponseEntity<Loan> create(@Valid @RequestBody Loan loan){
        Loan loanCreated = loanService.createLoan(loan);
        return ResponseEntity
                .created(URI.create("/api/loan" + loanCreated.getLoanId()))
                .body(loanCreated);
    }
}
