package se.lexicon.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.libraryapp.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

    List<AppUser> findByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<AppUser> findByDetails_Id(Long detailsId);

    Optional<AppUser> findByDetails_EmailIgnoreCase(String email);

}
