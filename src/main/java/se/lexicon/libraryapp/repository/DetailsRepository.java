package se.lexicon.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.libraryapp.entity.Details;

import java.util.List;
import java.util.Optional;

public interface DetailsRepository extends JpaRepository<Details, Long> {

    Optional<Details> findByEmail(String email);

    List<Details> findByNameContains(String name);

    List<Details> findByNameIgnoreCase(String name);

}
