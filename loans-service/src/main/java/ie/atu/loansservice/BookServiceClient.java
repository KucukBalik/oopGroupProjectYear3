package ie.atu.loansservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@FeignClient(name = "book-controller", url = "http://localhost:8080/book")
public interface BookServiceClient {


    @GetMapping("/books")
    HashMap<Integer, String> getBooks();
}
