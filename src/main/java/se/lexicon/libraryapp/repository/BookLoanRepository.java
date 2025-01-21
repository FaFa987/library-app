package se.lexicon.libraryapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.libraryapp.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Long> {

    List<BookLoan> findByBorrowerId(Long userId);
    List<BookLoan> findByBookId(Long bookId);
    List<BookLoan> findByReturnedFalse();
    List<BookLoan> findByDueDateBeforeAndReturnedFalse(LocalDate date);
    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

    @Modifying
    @Query("UPDATE BookLoan b SET b.returned = true WHERE b.id = :loanId")
    void markAsReturned(@Param("loanId") Long loanId);
}
