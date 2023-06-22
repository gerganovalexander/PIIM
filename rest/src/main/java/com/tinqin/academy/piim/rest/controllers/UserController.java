package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.user.create.CreateUserInput;
import com.tinqin.academy.piim.api.user.create.CreateUserOperation;
import com.tinqin.academy.piim.api.user.create.CreateUserResult;
import com.tinqin.academy.piim.api.user.delete.DeleteUserInput;
import com.tinqin.academy.piim.api.user.delete.DeleteUserOperation;
import com.tinqin.academy.piim.api.user.delete.DeleteUserResult;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersInput;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersOperation;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersResults;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdInput;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdOperation;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdResult;
import com.tinqin.academy.piim.api.user.update.UpdateUserInput;
import com.tinqin.academy.piim.api.user.update.UpdateUserOperation;
import com.tinqin.academy.piim.api.user.update.UpdateUserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserOperation createUserOperation;
    private final UpdateUserOperation updateUserOperation;
    private final DeleteUserOperation deleteUserOperation;
    private final GetUserByIdOperation getUserByIdOperation;
    private final GetAllUsersOperation getAllUsersOperation;

    @PostMapping
    public CreateUserResult createUser(@RequestBody CreateUserInput user) {
        return createUserOperation.process(user);
    }

    @PutMapping("/{id}")
    public UpdateUserResult updateUser(@PathVariable long id, @RequestBody UpdateUserInput updateUserInput) {
        updateUserInput.setId(id);
        return updateUserOperation.process(updateUserInput);
    }

    @DeleteMapping("/{id}")
    public DeleteUserResult deleteUser(@PathVariable long id) {
        return deleteUserOperation.process(DeleteUserInput.builder().id(id).build());
    }

    @GetMapping("/{id}")
    public GetUserByIdResult getUserById(@PathVariable long id) {
        return getUserByIdOperation.process(GetUserByIdInput.builder().id(id).build());
    }

    @GetMapping
    public GetAllUsersResults getAllUsers() {
        return getAllUsersOperation.process(new GetAllUsersInput());
    }
}
