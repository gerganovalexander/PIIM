package com.tinqin.academy.business.converters.user.get;

import com.tinqin.academy.api.user.getbyid.GetUserByIdResult;
import com.tinqin.academy.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToGetUserByIdResultConverter implements Converter<User, GetUserByIdResult> {
    @Override
    public GetUserByIdResult convert(User user) {
        return GetUserByIdResult.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
