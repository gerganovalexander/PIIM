package com.tinqin.academy.piim.business.converters.user.update;

import com.tinqin.academy.piim.api.user.update.UpdateUserResult;
import com.tinqin.academy.piim.data.models.User;
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
