package se.lexicon.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;
import se.lexicon.libraryapp.entity.Details;

import java.time.LocalDate;

@Getter
@Setter
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

    // @NonNull
    @OneToOne
    private Details details;


}