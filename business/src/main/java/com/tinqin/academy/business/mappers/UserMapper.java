package com.tinqin.academy.business.mappers;

import com.tinqin.academy.api.dtos.UserDto;
import com.tinqin.academy.data.models.User;

public class UserMapper {

    public static User dtoToUser(UserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        return user;
    }

    public static User dtoToUser(UserDto dto, long id) {
        User user = dtoToUser(dto);
        user.setId(id);
        return user;
    }

    public static UserDto userToDto(User user) {
        return new UserDto(user.getFirstName());
    }
}
