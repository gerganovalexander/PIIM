package com.tinqin.academy.piim.services.contracts;

import com.tinqin.academy.piim.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void createUser(User user);

    void updateUser(long id, User user);

    void deleteUser(long id);

    User getUserById(long id);

    List<User> getAllUsers();
}
