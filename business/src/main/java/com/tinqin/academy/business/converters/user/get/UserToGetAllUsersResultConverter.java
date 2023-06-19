package com.tinqin.academy.business.converters.user.get;

import com.tinqin.academy.api.user.getall.GetAllUsersResult;
import com.tinqin.academy.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToGetAllUsersResultConverter implements Converter<User, GetAllUsersResult> {
    @Override
    public GetAllUsersResult convert(User user) {
        return GetAllUsersResult.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
