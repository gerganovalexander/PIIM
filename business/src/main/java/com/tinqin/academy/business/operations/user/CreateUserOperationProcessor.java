package com.tinqin.academy.business.operations.user;

import com.tinqin.academy.api.user.create.CreateUserInput;
import com.tinqin.academy.api.user.create.CreateUserOperation;
import com.tinqin.academy.api.user.create.CreateUserResult;
import com.tinqin.academy.business.exceptions.DuplicateEntityException;
import com.tinqin.academy.data.models.User;
import com.tinqin.academy.data.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateUserOperationProcessor implements CreateUserOperation {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public CreateUserResult process(CreateUserInput inputUser) {
        Optional<User> optionalUser = Optional
                .ofNullable(conversionService.convert(inputUser, User.class));
        User user = optionalUser.orElseThrow(EntityNotFoundException::new);

        if (userRepository.existsUserByEmail(user.getEmail()))
            throw new DuplicateEntityException("User", "email", inputUser.getEmail());

        userRepository.save(user);
        return conversionService.convert(user, CreateUserResult.class);

    }
}
