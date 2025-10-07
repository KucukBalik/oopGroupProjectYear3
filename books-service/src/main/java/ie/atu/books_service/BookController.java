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
    public String getBooks()
    {
        Book myBook = new Book("Harry Potter", "JK Rowling", "JK Rowling");

        return myBook.toString();
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid Book myBook)
    {
        books.add(myBook);

        return myBook;
    }

    @PostMapping
    public List<Book> addBooks(@RequestBody  List<@Valid Book> myBooks)
    {
        books.addAll(myBooks);

        return books;


    }

}
