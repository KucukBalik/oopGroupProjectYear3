package repository;

import java.awt.print.Book;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findByBookId(String bookId);
    Optional<Book> findByName(String name);

    Book removeBook(String bookId);
}
