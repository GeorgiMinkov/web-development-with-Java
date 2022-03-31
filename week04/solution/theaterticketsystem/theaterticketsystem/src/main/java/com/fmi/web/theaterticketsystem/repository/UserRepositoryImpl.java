package com.fmi.web.theaterticketsystem.repository;

import com.fmi.web.theaterticketsystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    private Long currentElementId = 0L;

    @Override
    public synchronized void addUser(final User u) {
        u.setId(++currentElementId);
        users.putIfAbsent(u.getId(), u);
    }

    @Override
    public void deleteUser(final Long id) {
        users.remove(id);
    }

    @Override
    public User findById(final Long id) {
        return users.get(id);
    }

    @Override
    public void updateUser(final User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findByEmail(final String email) {
        return users.searchValues(2, user -> user.getEmail().equals(email) ? user : null);
    }
}
