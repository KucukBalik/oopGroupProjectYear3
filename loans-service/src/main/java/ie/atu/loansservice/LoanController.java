package ie.atu.loansservice;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.HashMap;

@RequestMapping("/loans")
@RestController
public class LoanController {

    @Autowired
    private BookServiceClient bookServiceClient;

    HashMap<Integer, String> borrowedBooks = new HashMap<>();

    @GetMapping("/displayBorrowedBooks")
    public HashMap<Integer, String> books(){

        return borrowedBooks;
    }

    @PostMapping("/addBorrowedBookToSystem/{id}")
    public HashMap<Integer, String> books(@PathVariable int id, @PathVariable @Valid Book myBook){

        bookServiceClient.getBooks();



        return borrowedBooks;
    }









}
