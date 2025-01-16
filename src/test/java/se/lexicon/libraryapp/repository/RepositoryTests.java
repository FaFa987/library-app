package se.lexicon.libraryapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.libraryapp.entity.AppUser;
import se.lexicon.libraryapp.entity.Details;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RepositoryTests {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    @Test
    void testFindByUsername() {
        AppUser user = new AppUser();
        user.setUsername("testUser");
        user.setRegistrationDate(LocalDate.now());
        appUserRepository.save(user);

        Optional<AppUser> foundUser = appUserRepository.findByUsername("testUser");
        assertTrue(foundUser.isPresent());
    }

    @Test
    void testFindByEmail() {
        Details details = new Details();
        details.setEmail("test@example.com");
        details.setName("John Doe");
        detailsRepository.save(details);

        Optional<Details> foundDetails = detailsRepository.findByEmail("test@example.com");
        assertTrue(foundDetails.isPresent());
    }
}
