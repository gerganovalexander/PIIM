package com.tinqin.academy.piim.business.operations.token;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.api.errors.token.FindByTokenError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.token.findbytoken.FindByTokenInput;
import com.tinqin.academy.piim.api.token.findbytoken.FindByTokenOperation;
import com.tinqin.academy.piim.api.token.findbytoken.FindByTokenResult;
import com.tinqin.academy.piim.data.repositories.TokenRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByTokenOperationProcessor implements FindByTokenOperation {

    private final TokenRepository tokenRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, FindByTokenResult> process(final FindByTokenInput input) {
        return Try.of(() -> FindByTokenResult.builder()
                        .tokenOutput(conversionService.convert(
                                tokenRepository.findByToken(input.getToken()).orElseThrow(), TokenOutput.class))
                        .build())
                .toEither()
                .mapLeft(throwable -> new FindByTokenError(400, throwable.getMessage()));
    }
}
