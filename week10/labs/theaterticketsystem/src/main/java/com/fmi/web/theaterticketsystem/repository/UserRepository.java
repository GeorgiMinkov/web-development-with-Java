package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

   Optional<User> findFirstByEmail(String email);
   List<User> findAll();
}
