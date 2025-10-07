package ie.atu.books_service;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    List<Book> books = new ArrayList<>();

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Book Service";
    }

    @GetMapping("/books")
    public List<Book> getBooks()
    {
        Book myBook = new Book("Harry Potter", "JK Rowling", "JK Rowling");
        books.add(myBook);

        return books;
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid Book myBook)
    {
        books.add(myBook);

        return myBook;
    }

    @PostMapping("/addBulkBook")
    public List<Book> bulkAdd(@RequestBody  List<@Valid Book> myBooks)
    {
        books.addAll(myBooks);

        return books;


    }

}
