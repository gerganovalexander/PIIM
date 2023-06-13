package com.tinqin.academy.business.services.contracts;

import com.tinqin.academy.data.models.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    void updateUser(long id, User user);

    void deleteUser(long id);

    User getUserById(long id);

    List<User> getAllUsers();
}
