package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.user.create.CreateUserInput;
import com.tinqin.academy.piim.api.user.create.CreateUserOperation;
import com.tinqin.academy.piim.api.user.delete.DeleteUserInput;
import com.tinqin.academy.piim.api.user.delete.DeleteUserOperation;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersInput;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersOperation;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdInput;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdOperation;
import com.tinqin.academy.piim.api.user.getbyusername.GetUserByEmailInput;
import com.tinqin.academy.piim.api.user.getbyusername.GetUserByEmailOperation;
import com.tinqin.academy.piim.api.user.update.UpdateUserInput;
import com.tinqin.academy.piim.api.user.update.UpdateUserOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController extends BaseController {

    private final CreateUserOperation createUserOperation;
    private final UpdateUserOperation updateUserOperation;
    private final DeleteUserOperation deleteUserOperation;
    private final GetUserByIdOperation getUserByIdOperation;
    private final GetAllUsersOperation getAllUsersOperation;
    private final GetUserByEmailOperation getUserByEmailOperation;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserInput user) {
        return handleOperation(createUserOperation.process(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UpdateUserInput updateUserInput) {
        updateUserInput.setId(id);
        return handleOperation(updateUserOperation.process(updateUserInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        return handleOperation(
                deleteUserOperation.process(DeleteUserInput.builder().id(id).build()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return handleOperation(
                getUserByIdOperation.process(GetUserByIdInput.builder().id(id).build()));
    }

    @GetMapping(params = "email")
    public ResponseEntity<?> getUserById(@RequestParam String email) {
        return handleOperation(getUserByEmailOperation.process(
                GetUserByEmailInput.builder().email(email).build()));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return handleOperation(getAllUsersOperation.process(new GetAllUsersInput()));
    }
}
