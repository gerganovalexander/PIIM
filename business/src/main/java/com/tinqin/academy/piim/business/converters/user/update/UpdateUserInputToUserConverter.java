package com.tinqin.academy.piim.business.converters.user.update;

import com.tinqin.academy.piim.api.user.update.UpdateUserInput;
import com.tinqin.academy.piim.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserInputToUserConverter implements Converter<UpdateUserInput, User> {

    @Override
    public User convert(UpdateUserInput userInput) {
        return User.builder()
                .id(userInput.getId())
                .firstName(userInput.getFirstName())
                .lastName(userInput.getLastName())
                .email(userInput.getEmail())
                .build();
    }
}
