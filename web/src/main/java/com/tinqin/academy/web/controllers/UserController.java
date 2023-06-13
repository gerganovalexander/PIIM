package com.tinqin.academy.web.controllers;


import com.tinqin.academy.business.dtos.UserDto;
import com.tinqin.academy.business.mappers.UserMapper;
import com.tinqin.academy.business.services.contracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.tinqin.academy.business.mappers.UserMapper.dtoToUser;
import static com.tinqin.academy.business.mappers.UserMapper.userToDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        userService.createUser(dtoToUser(user));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto user) {
        userService.updateUser(id, dtoToUser(user, id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return userToDto(userService.getUserById(id));

    }

    @GetMapping("/all-users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
    }


}
