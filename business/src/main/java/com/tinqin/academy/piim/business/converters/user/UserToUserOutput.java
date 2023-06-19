package com.tinqin.academy.piim.business.converters.user;

import com.tinqin.academy.piim.api.entityoutputmodels.UserOutput;
import com.tinqin.academy.piim.data.models.User;
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
