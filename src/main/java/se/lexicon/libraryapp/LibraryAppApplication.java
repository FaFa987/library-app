package se.lexicon.libraryapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.lexicon.libraryapp.repository.AppUserRepository;
import se.lexicon.libraryapp.repository.BookLoanRepository;
import se.lexicon.libraryapp.repository.BookRepository;
import se.lexicon.libraryapp.repository.DetailsRepository;

@SpringBootApplication
public class LibraryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(DetailsRepository detailsRepository, AppUserRepository userRepository , BookRepository bookRepository , BookLoanRepository bookLoanRepository) {
        return args -> {
            // Interact with App/Repos here.
        };
    }


}
