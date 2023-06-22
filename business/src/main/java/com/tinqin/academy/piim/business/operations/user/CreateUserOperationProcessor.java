package com.tinqin.academy.piim.business.operations.user;

import com.tinqin.academy.piim.api.user.create.CreateUserInput;
import com.tinqin.academy.piim.api.user.create.CreateUserOperation;
import com.tinqin.academy.piim.api.user.create.CreateUserResult;
import com.tinqin.academy.piim.data.models.User;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
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
        Optional<User> optionalUser = Optional.ofNullable(conversionService.convert(inputUser, User.class));
        User user = optionalUser.orElseThrow(EntityNotFoundException::new);

        if (userRepository.existsUserByEmail(user.getEmail()))
            throw new EntityExistsException(String.format("User with email %s already exists.", inputUser.getEmail()));

        userRepository.save(user);
        return conversionService.convert(user, CreateUserResult.class);
    }
}
