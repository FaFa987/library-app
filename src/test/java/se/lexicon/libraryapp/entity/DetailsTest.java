package se.lexicon.libraryapp.entity;

import lombok.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DetailsTest {


    private int id = 1;
    private String email = "test@example.com";
    private String name = "test";
    private LocalDate birthDate = LocalDate.parse("1990-01-01");

    private Details testObject;

    @BeforeEach
    void setUp() {

        testObject = new Details(id, email, name, birthDate);
    }

    @Test
    void ToString() {

        String ToString = testObject.toString();

        assertTrue(toString().contains("id: " + id));
        assertTrue(toString().contains(email));
        assertTrue(toString().contains(name));
        //assertTrue(toString().contains(birthDate));
    }
}