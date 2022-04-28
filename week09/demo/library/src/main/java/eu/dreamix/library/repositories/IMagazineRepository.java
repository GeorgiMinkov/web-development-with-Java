package eu.dreamix.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.dreamix.library.models.Magazine;

@Repository
public interface IMagazineRepository extends CrudRepository<Magazine, String> {}
