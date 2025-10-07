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

    @PostMapping("/deleteBook")
    public HashMap<Integer, Book> myBooks (@RequestBody @Valid Integer ID){

        booksMap.remove(ID);
        removedIDs.add(ID);
        return booksMap;

    }

   // @PostMapping("/restartThe")


}
