package se.lexicon.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

@SuppressWarnings("ALL")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PROTECTED)

@Entity
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private int id;

    @NonNull
    private String isbn;
    @NonNull
    private String title;
    @NonNull
    private int maxLoanDays;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(int id, String title, int maxLoanDays, String isbn) {
        this.id = id;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.isbn = isbn;
    }
}
