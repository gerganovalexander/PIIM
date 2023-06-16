package com.tinqin.academy.business.converters.user.create;

import com.tinqin.academy.api.user.create.CreateUserInput;
import com.tinqin.academy.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateUserInputToUserConverter implements Converter<CreateUserInput, User> {

    @Override
    public User convert(CreateUserInput user) {
        return User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
