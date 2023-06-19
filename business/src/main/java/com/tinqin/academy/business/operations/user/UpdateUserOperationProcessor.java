package com.tinqin.academy.business.operations.user;

import com.tinqin.academy.api.user.update.UpdateUserInput;
import com.tinqin.academy.api.user.update.UpdateUserOperation;
import com.tinqin.academy.api.user.update.UpdateUserResult;
import com.tinqin.academy.data.models.User;
import com.tinqin.academy.data.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateUserOperationProcessor implements UpdateUserOperation {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public UpdateUserResult process(UpdateUserInput userInput) {
        Optional<User> optionalUser = Optional.ofNullable(conversionService.convert(userInput, User.class));
        User user = optionalUser.orElseThrow(EntityNotFoundException::new);

        Long id = user.getId();
        String email = userInput.getEmail();
        if (userRepository.existsUserByEmail(email) && !userRepository.findByEmail(email).getId().equals(id)) {
            throw new EntityExistsException(String.format("User with email %s already exists.", userInput.getEmail()));
        }
        userRepository.updateFieldsByUser(id, user);
        return conversionService.convert(user, UpdateUserResult.class);
    }
}
