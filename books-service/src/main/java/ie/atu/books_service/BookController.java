package ie.atu.books_service;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    List<Book> books = new ArrayList<>();
    HashMap<Integer, Book> booksMap = new HashMap<>();
    List<Integer> removedIDs = new ArrayList<>();

    int ID = 0;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Book Service";
    }

    @GetMapping("/books")
    public HashMap<Integer, Book> getBooks()
    {
        return booksMap;
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid Book myBook)
    {
        if(removedIDs.isEmpty()==false){
            Collections.sort(removedIDs);
            booksMap.put(removedIDs.getFirst(), myBook);
        }else{
            ID++;
            booksMap.put(ID, myBook);
        }

        return myBook;
    }

    @PostMapping("/addBulkBook")
    public HashMap<Integer, Book> myBooks(@RequestBody  List<@Valid Book> myBooks)
    {
        books.addAll(myBooks);

        for(int i = 0; i < myBooks.size(); i++){
            if(removedIDs.isEmpty()==false){
                Collections.sort(removedIDs);
                booksMap.put(removedIDs.getFirst(), myBooks.get(i));
            }else{
                ID++;
                booksMap.put(ID, myBooks.get(i));
            }

        }

        return booksMap;


    }

    @PostMapping("/update/{id}/")
    public HashMap<Integer, Book> myBooks(@PathVariable int id, @RequestBody @Valid Book myBook)
    {

        booksMap.put(id, myBook);

        return booksMap;
    }


    @DeleteMapping("/delete/{id}")
    public HashMap<Integer, Book> myBooks (@PathVariable int id) {

        booksMap.remove(id);
        removedIDs.add(id);
        return booksMap;

    }


}
