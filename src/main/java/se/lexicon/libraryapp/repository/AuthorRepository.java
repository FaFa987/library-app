package se.lexicon.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.libraryapp.entity.Author;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    // Find authors by their first name
    List<Author> findByFirstName(String firstName);

    // Find authors by their last name
    List<Author> findByLastName(String lastName);

    // Find authors by their first or last name containing a keyword
    List<Author> findByFirstNameContainingOrLastNameContaining(String firstNameKeyword, String lastNameKeyword);

    // Find authors by a book's ID
    @Query("SELECT a FROM Author a JOIN a.writtenBooks b WHERE b.id = :bookId")
    Optional<Author> findAuthorByBookId(@Param("bookId") Long bookId);
}