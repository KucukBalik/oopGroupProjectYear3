package ie.atu.books_service;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/book")
@RestController
public class BookController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Book Service";
    }
}
