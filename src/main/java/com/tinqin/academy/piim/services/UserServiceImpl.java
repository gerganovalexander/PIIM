package com.tinqin.academy.piim.services;

import com.tinqin.academy.piim.exceptions.DuplicateEntityException;
import com.tinqin.academy.piim.models.User;
import com.tinqin.academy.piim.repositories.UserRepository;
import com.tinqin.academy.piim.services.contracts.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void createUser(User user) {
        checkForDuplication(user);
        userRepository.save(user);
    }

    @Override
    public void updateUser(long id, User user) {
        try {
            getUserById(id);
            userRepository.updateFieldsByUser(id, user);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public void deleteUser(long id) {
        try {
            User userToDelete = getUserById(id);
            userRepository.delete(userToDelete);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("User not found");
        }
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new EntityNotFoundException("User with ID :" + id + " not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }


    private void checkForDuplication(User user) {
        boolean doesExist = userRepository.existsUserByEmail(user.getEmail());
        if (doesExist) {
            throw new DuplicateEntityException("User", "email", user.getEmail());
        }
    }
}
