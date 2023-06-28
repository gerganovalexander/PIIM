package com.tinqin.academy.piim.api.gamepatch.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteGamePatchInput implements OperationInput {
    @NotNull
    private Long id;
}
