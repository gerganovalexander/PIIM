package com.tinqin.academy.piim.api.game.getbyname;

import com.tinqin.academy.piim.api.generics.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameGameInput implements OperationInput {
    @NotNull
    private String name;
}