package com.tinqin.academy.piim.api.game.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteGameInput implements OperationInput {
    @NotNull
    private Long id;
}
