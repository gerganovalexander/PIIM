package com.tinqin.academy.business.converters;

import com.tinqin.academy.api.entityoutputmodels.UserOutput;
import com.tinqin.academy.data.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserOutput implements Converter<User, UserOutput> {


    @Override
    public UserOutput convert(User source) {
        return UserOutput.builder()
                .id(source.getId())
                .fullName(source.getFirstName() + " " + source.getLastName())
                .build();
    }

}
