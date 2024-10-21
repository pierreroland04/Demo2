package heh.be.demo.Service;

import java.awt.print.Book;
import java.util.List;

public interface BookUseCase {
    Book findBookById(int id);
    List<Book> findBooks();
    Book findAllBooks();
    void deleteBookById(int id);
}
