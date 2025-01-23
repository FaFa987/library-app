package se.lexicon.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;
import se.lexicon.libraryapp.entity.Details;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private int id;

    @NonNull
    private String username;
    @NonNull
    private String password;

    private LocalDate regDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    public List<BookLoan> getBookLoans() {
        return bookLoans;
    }

    public void setBookLoans(List<BookLoan> bookLoans) {
        this.bookLoans = bookLoans;
    }

    // @NonNull
    @OneToOne
    private Details userDetails;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookLoan> bookLoans = new ArrayList<>();

    public void addBookLoan(BookLoan bookLoan) {
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);
    }

    public void removeBookLoan(BookLoan bookLoan) {
        bookLoans.remove(bookLoan);
        bookLoan.setBorrower(null);
    }

}