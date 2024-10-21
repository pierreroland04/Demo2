package heh.be.demo.vue;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> books = new ArrayList<>();

    public Books() {
        books.add(new Book("Livre 1", 1));
        books.add(new Book("Livre 2", 2));
        books.add(new Book("Livre 3", 3));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean removeBookById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
