package se.lexicon.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.libraryapp.entity.Details;

import java.util.List;
import java.util.Optional;

public interface DetailsRepository extends CrudRepository<Details, Long> {

    Optional<Details> findByEmail(String email);

    List<Details> findByNameContains(String name);

    List<Details> findByNameIgnoreCase(String name);

}
