package ie.atu.books_service.service;

import org.springframework.stereotype.Service;

import ie.atu.users_service.model.Book;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> userList = new ArrayList<>();

    // Defensive Copy of User List -
    public List<Book> getUserList(){
        return new ArrayList<>(userList);
    }

    // Search By ID
    public Optional<Book> getUserByID(String id){
        for (Book user : userList){
            if(user.getBookID().equals(id)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    // Create Multiple Users
    public List<Book> createUsers(List<Book> userList){
        List<Book> addedBooks = new ArrayList<>();
        for(Book user : userList){
            if(getUserByID(user.getBookID()).isPresent()){
                throw new DuplicateExceptionHandling("Book " + user.getBookID() + " already exists D:");
            }
            addedBooks.add(createBook(book));
        }
        return addedBooks;
    }

    // Create One User
    public Book createUser(Book book){
        if(getBookByID(book.getBookID()).isPresent()){
            throw new DuplicateExceptionHandling("Book " + book.getBookID() + " already exists D:");
        }
        bookList.add(book);
        return book;
    }

    // Update User
    public Book update(Book user) {
        Optional<Book> bookFound = getBookByID(user.getBookID());
        if(bookFound.isPresent()){
            Book updated = bookFound.get();
            updated.setName(book.getName());
            updated.setPublisher(book.getPubliusher());
            updated.setAuthor(book.getAuthor());

            return updated;
        }
        throw new NotFoundException("Book " +  user.getBookID() + " doesnt exist");
    }

    // Delete User
    public Book deleteBook(Book bookFound) {
        if(getBookByID(bookFound.getBookID()).isPresent()){
            bookList.remove(bookFound);
            return bookFound;
        }
        throw new NotFoundException("Book " + bookFound.getBookID() + " not found");
    }



}



