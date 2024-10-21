package heh.be.demo.controller;

import heh.be.demo.Service.BookUseCase;
import heh.be.demo.vue.Books;
import heh.be.demo.vue.Book;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class Controller {

    private Books books = new Books();

    //private final BookUseCase bookUseCase;

    @PostMapping("/books/{id}")
    public ResponseEntity<Books> ajouterLivreAvecId(@PathVariable int id) {
        Book book = new Book();
        book.setId(id);
        book.setTitle("Livre"+id);
        books.addBook(book);
        String url = "http://localhost:8090/books/" + id;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location",url)
                .build();
    }

    @PostMapping("/books")
    public ResponseEntity<Books> ajouterLivreAvecBody(@Valid @RequestBody Book book) {
        //var book = Book.builder().title("titl").build(); exemple avec .builder
        books.addBook(book);
        String url = "http://localhost:8090/books";
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location",url)
                .build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Books> supprimerLivre(@PathVariable int id) {
        boolean deleted = books.removeBookById(id);
        if (deleted) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }
    // faire avec request param aussi pour test. Exemple : /book/query?id=1
    @GetMapping("/books")
    public ResponseEntity<Books> afficherTousLesLivres() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> afficherLivreParId(@PathVariable int id) {
        Optional<Book> livre = books.getBooks().stream()
                .filter(b -> b.getId() == id)
                .findFirst();
        return livre.map(book -> ResponseEntity
                .status(HttpStatus.FOUND)
                .body(book)).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null));

        // revient au même
        /*if (livre.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(livre.get());
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }*/
    }
}
