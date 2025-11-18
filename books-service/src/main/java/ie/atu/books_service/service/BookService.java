package ie.atu.books_service.service;


import ie.atu.books_service.model.Book;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Optional<Book> findById(String id) {

        for (Book book : books) {
            if(book.getBookID().equals(id)) {
                return Optional.of(book);
            }
        }

        return Optional.empty();

    }

    public Book create(Book book) {

        if(book.getBookID() == null) {

            books.add(book);
            return book;

        }else{

            throw new RuntimeException("Book ID with " + book.getBookID() + " already exists");

        }


    }

    public Book update(Book book) {

        if(book.getBookID() == null) {

            throw new RuntimeException("Book ID doesn't exist");

        }else{


            books.set(books.indexOf(book), book);
            return book;


        }


    }

    public void delete(String id) {

        if (findById(id).isPresent()) {
            books.remove(findById(id).get());
        } else {
            throw new RuntimeException("Book ID doesn't exist");

        }
    }








}
