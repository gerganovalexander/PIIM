package com.tinqin.academy.piim.api.gamepatch.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGamePatchInput implements OperationInput {
    @NotNull
    private Long id;

    @NotNull
    private String description;
}
