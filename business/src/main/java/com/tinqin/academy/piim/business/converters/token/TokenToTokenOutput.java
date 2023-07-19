package com.tinqin.academy.piim.business.converters.token;

import com.tinqin.academy.piim.api.entityoutputmodels.TokenOutput;
import com.tinqin.academy.piim.data.models.Token;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TokenToTokenOutput implements Converter<Token, TokenOutput> {
    @Override
    public TokenOutput convert(Token source) {
        return TokenOutput.builder()
                .id(source.getId())
                .tokenType(String.valueOf(source.getTokenType()))
                .expired(source.isExpired())
                .revoked(source.isRevoked())
                .userId(source.getUser().getId())
                .build();
    }
}
