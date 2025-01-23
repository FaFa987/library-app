package se.lexicon.libraryapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Details {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private int id;

    @NonNull
    private String email;
    @NonNull
    private String name;
    @NonNull
    private LocalDate birthDate;

    public Details(int id, @NonNull String email, @NonNull String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NonNull String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NonNull LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}