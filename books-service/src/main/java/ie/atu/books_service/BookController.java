package ie.atu.books_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
public class BookController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Book Service";
    }
}
