package com.tinqin.academy.piim.api.gamepatch.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGamePatchInput implements OperationInput {

    @NotNull
    private Long gameId;

    @NotNull
    private String version;

    @NotNull
    private String description;
}
