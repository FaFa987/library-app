package se.lexicon.libraryapp.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)


public class Details {


    @Setter(AccessLevel.PROTECTED)
    private int id;

    @NonNull
    private String email;
    @NonNull
    private String name;
    @NonNull
    private LocalDate birthDate;

}