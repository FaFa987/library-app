package se.lexicon.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
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
    private boolean returned;

    @ManyToOne
    private AppUser borrower;

    @ManyToOne
    private Book book;
}
