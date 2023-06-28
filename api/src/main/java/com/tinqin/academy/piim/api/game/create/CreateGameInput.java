package com.tinqin.academy.piim.api.game.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGameInput implements OperationInput {

    @NotNull
    private String name;

    private LocalDateTime releaseDate;

    private String publisher;

    public Optional<LocalDateTime> getReleaseDate() {
        return Optional.ofNullable(releaseDate);
    }

    public Optional<String> getPublisher() {
        return Optional.ofNullable(publisher);
    }
}
