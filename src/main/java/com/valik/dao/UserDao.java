package com.valik.dao;

import com.valik.model.User;

import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    Optional<User> getByEmail(String email);
}
