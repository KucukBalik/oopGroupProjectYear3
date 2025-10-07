package ie.atu.books_service;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    public String name;
    public String author;
    public String publisher;
}
