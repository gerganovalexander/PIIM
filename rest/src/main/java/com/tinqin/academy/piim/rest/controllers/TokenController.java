package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.token.create.CreateTokenInput;
import com.tinqin.academy.piim.api.token.create.CreateTokenOperation;
import com.tinqin.academy.piim.api.token.findallvalidtokenbyuser.FindAllValidTokenByUserInput;
import com.tinqin.academy.piim.api.token.findallvalidtokenbyuser.FindAllValidTokenByUserOperation;
import com.tinqin.academy.piim.api.token.findbytoken.FindByTokenInput;
import com.tinqin.academy.piim.api.token.findbytoken.FindByTokenOperation;
import com.tinqin.academy.piim.api.token.revoke.RevokeTokenInput;
import com.tinqin.academy.piim.api.token.revoke.RevokeTokenOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tokens")
public class TokenController extends BaseController {

    private final CreateTokenOperation createTokenOperation;
    private final FindByTokenOperation findByTokenOperation;
    private final FindAllValidTokenByUserOperation findAllValidTokenByUserOperation;
    private final RevokeTokenOperation revokeTokenOperation;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateTokenInput input) {
        return handleOperation(createTokenOperation.process(input));
    }

    @GetMapping(params = "token")
    public ResponseEntity<?> findByToken(@RequestParam String token) {
        return handleOperation(findByTokenOperation.process(
                FindByTokenInput.builder().token(token).build()));
    }

    @GetMapping(params = "email")
    public ResponseEntity<?> findAllValidTokenByUser(@RequestParam String email) {
        return handleOperation(findAllValidTokenByUserOperation.process(
                FindAllValidTokenByUserInput.builder().email(email).build()));
    }

    @PutMapping(path = "/revoke", params = "token")
    public ResponseEntity<?> revoke(@RequestParam String token) {
        return handleOperation(revokeTokenOperation.process(
                RevokeTokenInput.builder().token(token).build()));
    }
}
