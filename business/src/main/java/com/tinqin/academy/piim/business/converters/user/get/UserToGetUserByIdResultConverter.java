package com.tinqin.academy.piim.business.converters.user.get;

import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdResult;
import com.tinqin.academy.piim.data.models.User;
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
