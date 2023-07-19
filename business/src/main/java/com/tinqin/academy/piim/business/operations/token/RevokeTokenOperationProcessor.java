package com.tinqin.academy.piim.business.operations.token;

import com.tinqin.academy.piim.api.errors.token.RevokeTokenError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.token.revoke.RevokeTokenInput;
import com.tinqin.academy.piim.api.token.revoke.RevokeTokenOperation;
import com.tinqin.academy.piim.api.token.revoke.RevokeTokenResult;
import com.tinqin.academy.piim.data.models.Token;
import com.tinqin.academy.piim.data.repositories.TokenRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RevokeTokenOperationProcessor implements RevokeTokenOperation {

    private final TokenRepository tokenRepository;

    @Override
    public Either<PiimError, RevokeTokenResult> process(RevokeTokenInput input) {
        if (tokenRepository.existsByToken(input.getToken())) {
            Token token = tokenRepository.findByToken(input.getToken()).orElseThrow();
            token.setRevoked(true);
            token.setExpired(true);
            tokenRepository.save(token);
            return Either.right(RevokeTokenResult.builder().success(true).build());
        }
        return Either.left(new RevokeTokenError(400, "pak lesh"));
    }
}
