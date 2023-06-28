package com.tinqin.academy.piim.api.game.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdGameInput implements OperationInput {
    @NotNull
    private Long id;
}
