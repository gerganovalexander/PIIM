package com.tinqin.academy.piim.business.operations.token;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.api.errors.token.CreateTokenError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.token.create.CreateTokenInput;
import com.tinqin.academy.piim.api.token.create.CreateTokenOperation;
import com.tinqin.academy.piim.api.token.create.CreateTokenResult;
import com.tinqin.academy.piim.data.models.Token;
import com.tinqin.academy.piim.data.models.TokenType;
import com.tinqin.academy.piim.data.repositories.TokenRepository;
import com.tinqin.academy.piim.data.repositories.UserRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTokenOperationProcessor implements CreateTokenOperation {
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, CreateTokenResult> process(final CreateTokenInput input) {
        return Try.of(() -> {
                    Token token = Token.builder()
                            .token(input.getToken())
                            .tokenType(TokenType.valueOf(input.getTokenType()))
                            .user(userRepository
                                    .findUserByEmail(input.getEmail())
                                    .orElseThrow())
                            .revoked(false)
                            .expired(false)
                            .build();

                    if (tokenRepository.existsByToken(token.getToken()))
                        throw new EntityExistsException("Token already exists.");

                    tokenRepository.save(token);

                    return CreateTokenResult.builder()
                            .token(conversionService.convert(token, TokenOutput.class))
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new CreateTokenError(400, throwable.getMessage()));
    }
}
