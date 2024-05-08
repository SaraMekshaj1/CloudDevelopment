package com.hendisantika.springbootrestapipostgresql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hendisantika.springbootrestapipostgresql.controller.BookRestController;
import com.hendisantika.springbootrestapipostgresql.entity.Book;
import com.hendisantika.springbootrestapipostgresql.repository.BookRepository;


@SpringBootTest
@AutoConfigureMockMvc
public class BookRestControllerTest {
    private BookRestController bookController;
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookController = new BookRestController(bookRepository);
    }

    @Test
    void testAddBook() {
        Book book = new Book("The End of Everything", "How Wars Descend into Annihilation ", new ArrayList<>());
        when(bookRepository.save(book)).thenReturn(book);

        ResponseEntity<?> responseEntity = bookController.addBook(book);

        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The End of Everything", "How Wars Descend into Annihilation ", new ArrayList<>()));
        books.add(new Book("Clean Code", "A Handbook of Agile Software Craftsmanship", new ArrayList<>()));

        when(bookRepository.findAll()).thenReturn(books);

        ResponseEntity<Collection<Book>> responseEntity = bookController.getAllBooks();

        assertNotNull(responseEntity.getBody());
        assertEquals(2, responseEntity.getBody().size());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetBookWithId() {
        Long bookId = 1L;
        Book book = new Book("The End of Everything", "How Wars Descend into Annihilation", new ArrayList<>());
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        ResponseEntity<Book> responseEntity = bookController.getBookWithId(bookId);

        assertNotNull(responseEntity.getBody());
        assertEquals("The End of Everything", responseEntity.getBody().getName());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testFindBookWithName() {
        String bookName = "The End of Everything";
        List<Book> books = new ArrayList<>();
        books.add(new Book(bookName, "How Wars Descend into Annihilation", new ArrayList<>()));

        when(bookRepository.findByName(bookName)).thenReturn(books);

        ResponseEntity<Collection<Book>> responseEntity = bookController.findBookWithName(bookName);

        assertNotNull(responseEntity.getBody());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals(bookName, responseEntity.getBody().iterator().next().getName());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateBookFromDB() {
        Long bookId = 1L;
        Book existingBook = new Book("The End of Everything", "How Wars Descend into Annihilation", new ArrayList<>());
        Book updatedBook = new Book("The End of Everything", "How Wars Descend into Annihilation", new ArrayList<>());

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(existingBook)).thenReturn(updatedBook);

        ResponseEntity<Book> responseEntity = bookController.updateBookFromDB(bookId, updatedBook);

        assertNotNull(responseEntity.getBody());
        assertEquals("The End of Everything", responseEntity.getBody().getName());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteBookWithId() {
        Long bookId = 1L;
        ResponseEntity<Void> responseEntity = bookController.deleteBookWithId(bookId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(bookRepository).deleteById(bookId);
    }

    @Test
    void testDeleteAllBooks() {
        ResponseEntity<Void> responseEntity = bookController.deleteAllBooks();

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(bookRepository).deleteAll();
    }
}