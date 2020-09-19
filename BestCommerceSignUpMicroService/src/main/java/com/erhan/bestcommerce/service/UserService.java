package com.erhan.bestcommerce.service;

import java.util.List;

import com.erhan.bestcommerce.entity.User;

public interface UserService {
    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    Long numberOfUsers();

}
