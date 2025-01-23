package se.lexicon.libraryapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.lexicon.libraryapp.entity.Details;
import se.lexicon.libraryapp.repository.AppUserRepository;
import se.lexicon.libraryapp.repository.BookLoanRepository;
import se.lexicon.libraryapp.repository.BookRepository;
import se.lexicon.libraryapp.repository.DetailsRepository;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(DetailsRepository detailsRepository) {
        return args -> {
            // Example interaction
            Details details = new Details(1, "john.doe@example.com", "John Doe", LocalDate.of(1990, 1, 1));
            detailsRepository.save(details);

            detailsRepository.findAll().forEach(System.out::println);
        };
    }


}
