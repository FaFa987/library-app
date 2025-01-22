package se.lexicon.libraryapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.libraryapp.entity.Author;
import se.lexicon.libraryapp.entity.Book;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryTest {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Test
    void testFindByFirstName() {
        Author author = new Author(1, "Alex", "Hook");
        author.setFirstName("John");
        author.setLastName("Doe");
        authorRepository.save(author);

        List<Author> authors = authorRepository.findByFirstName("John");
        assertEquals(1, authors.size());
    }

    @Test
    void testFindByLastName() {
        Author author = new Author(1, "Devid", "Hook");
        author.setFirstName("Jane");
        author.setLastName("Smith");
        authorRepository.save(author);

        List<Author> authors = authorRepository.findByLastName("Smith");
        assertEquals(1, authors.size());
    }

    @Test
    void testFindByFirstNameOrLastNameContaining() {
        Author author = new Author(1, "John", "Hook");
        author.setFirstName("Alice");
        author.setLastName("Johnson");
        authorRepository.save(author);

        List<Author> authors = authorRepository.findByFirstNameContainingOrLastNameContaining("Ali", "John");
        assertEquals(1, authors.size());
    }

    @Test
    void testFindAuthorByBookId() {
        Author author = new Author(1,"jain" , "hook");
        author.setFirstName("Mark");
        author.setLastName("Twain");
        authorRepository.save(author);

        Book book = new Book(1, "Petter" ,23 ,"yes");
        book.setTitle("The Adventures of Tom Sawyer");
        book.setAuthor(author);
        bookRepository.save(book);

        Optional<Author> foundAuthor = authorRepository.findAuthorByBookId(valueOf(book.getId()));
        assertTrue(foundAuthor.isPresent());
        assertEquals("Mark", foundAuthor.get().getFirstName());
    }
}