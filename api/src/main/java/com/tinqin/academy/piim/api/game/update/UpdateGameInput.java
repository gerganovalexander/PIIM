package com.tinqin.academy.piim.api.game.update;

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
public class UpdateGameInput implements OperationInput {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    private Optional<LocalDateTime> releaseDate = Optional.empty();

    private Optional<String> publisher = Optional.empty();
}
