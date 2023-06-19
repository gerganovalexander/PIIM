package com.tinqin.academy.business.converters.user.update;

import com.tinqin.academy.api.user.update.UpdateUserResult;
import com.tinqin.academy.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResultConverter implements Converter<User, UpdateUserResult> {
    @Override
    public UpdateUserResult convert(User userResult) {
        return UpdateUserResult.builder()
                .id(userResult.getId())
                .firstName(userResult.getFirstName())
                .lastName(userResult.getLastName())
                .email(userResult.getEmail())
                .build();
    }
}
