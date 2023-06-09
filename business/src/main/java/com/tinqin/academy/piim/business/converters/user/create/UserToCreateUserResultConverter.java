package com.tinqin.academy.piim.business.converters.user.create;

import com.tinqin.academy.piim.api.user.create.CreateUserResult;
import com.tinqin.academy.piim.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToCreateUserResultConverter implements Converter<User, CreateUserResult> {
    @Override
    public CreateUserResult convert(User user) {
        return CreateUserResult.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
