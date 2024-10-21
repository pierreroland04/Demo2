package heh.be.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import heh.be.demo.Service.BookUseCase;
import heh.be.demo.controller.Controller;
import heh.be.demo.vue.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//@SpringBootTest

@WebMvcTest(controllers = Controller.class)
class DemoApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookUseCase bookService;

	@Test
	public void postBook() throws Exception {
		int id = 5;
		Book book = new Book();
		book.setId(id);
		book.setTitle("Livre" + id);

		String bookJson = new ObjectMapper().writeValueAsString(book);
		String url = "http://localhost:8090/books";

		mvc.perform(MockMvcRequestBuilders.post("/books")
				.content(bookJson)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().string("Location", url));
	}

	@Test
	public void getBooks() throws Exception {
		int id = 5;
		Book book = new Book();
		book.setId(id);
		book.setTitle("Livre" + id);
		String bookJson = new ObjectMapper().writeValueAsString(book);
		//String url = "http://localhost:8090/books";
		mvc.perform(MockMvcRequestBuilders.get("/books")
				.content(bookJson)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		);
	}

	@Test
	@DisplayName("GET http://localhost:8090/books/4")
	public void testGetPatientsByIdFound() throws Exception {
		Book book = new Book();
		book.setId(4);
		book.setTitle("Livre" + book.getId());
		String bookJson = new ObjectMapper().writeValueAsString(book);
		mvc.perform(MockMvcRequestBuilders.get("/books/4")
				.content(bookJson)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		);
	}
}
