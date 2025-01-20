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

public class AppUser {


    @Setter(AccessLevel.NONE)
    private int id;

    @NonNull
    private String username;
    @NonNull
    private String password;

    private LocalDate regDate;

    @NonNull
    private Details details;


}