package ie.atu.loansservice.controller;

import ie.atu.loansservice.errorHandling.NotFoundException;
import ie.atu.loansservice.feign.client.LoanServiceClient;
import ie.atu.loansservice.model.Loan;
import ie.atu.loansservice.model.UserDTO;
import ie.atu.loansservice.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private final LoanServiceClient loanServiceClient;

    public LoanController(LoanService loanService, LoanServiceClient loanServiceClient){
        this.loanService = loanService;
        this.loanServiceClient = loanServiceClient;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> testGetUser(@PathVariable String userId){
        UserDTO fromUsers = loanServiceClient.getUserById(userId);
        return ResponseEntity.ok(fromUsers);
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
            throw new NotFoundException(id + " Doesnt Exist");
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