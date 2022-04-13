package com.dreamix.fmi.WebServices.repo.user;

import com.dreamix.fmi.WebServices.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
