package se.lexicon.libraryapp.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.libraryapp.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByIsbnIgnoreCase(String isbn);
    List<Book> findByTitleContaining(String title);
    List<Book> findByMaxLoanDaysLessThan(int maxDays);
}
