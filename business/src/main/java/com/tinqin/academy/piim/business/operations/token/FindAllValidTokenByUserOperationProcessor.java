package com.tinqin.academy.piim.business.operations.token;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.token.findallvalidtokenbyuser.FindAllValidTokenByUserInput;
import com.tinqin.academy.piim.api.token.findallvalidtokenbyuser.FindAllValidTokenByUserOperation;
import com.tinqin.academy.piim.api.token.findallvalidtokenbyuser.FindAllValidTokenByUserResult;
import com.tinqin.academy.piim.data.models.Token;
import com.tinqin.academy.piim.data.repositories.TokenRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllValidTokenByUserOperationProcessor implements FindAllValidTokenByUserOperation {

    private final TokenRepository tokenRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, FindAllValidTokenByUserResult> process(final FindAllValidTokenByUserInput input) {
        List<Token> tokens = tokenRepository.findAllValidTokenByUser(input.getUserId());
        return Either.right(FindAllValidTokenByUserResult.builder()
                .tokens(tokens.stream()
                        .map(token -> conversionService.convert(token, TokenOutput.class))
                        .collect(Collectors.toList()))
                .build());
    }
}
