package com.tinqin.academy.piim.api.gamepatch.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetGamePatchByIdInput implements OperationInput {
    @NotNull
    private Long id;
}
