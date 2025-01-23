package se.lexicon.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PROTECTED)

@Entity
public class BookLoan {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Setter (AccessLevel.PROTECTED)
    private int id;

    @NonNull
    private LocalDate loanDate;
    @NonNull
    private LocalDate dueDate;
    @NonNull
    private boolean returned = false;

    // @ManyToOne
    // private AppUser borrower;

    @ManyToOne
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", nullable = false)
    private AppUser borrower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;



    /*@PreUpdate
    public void calculateDueDate() {
        if (book != null && loanDate != null) {
            this.dueDate = loanDate.plusDays(book.getMaxLoanDays());
        }
    }*/

    @PrePersist
    public void checkAndSetBookAvailability() {
        if (book == null || !book.isAvailable()) {
            throw new IllegalStateException("The book is not available for loan.");
        }
        book.setAvailable(false);
    }

    public void markAsReturned() {
        if (returned) {
            throw new IllegalStateException("The book loan is already marked as returned.");
        }
        this.returned = true;
        if (book != null) {
            book.setAvailable(true);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NonNull LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(@NonNull LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public @NonNull LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NonNull LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @NonNull
    public boolean isReturned() {
        return returned;
    }

    public void setReturned(@NonNull boolean returned) {
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
