package com.tinqin.academy.piim.api.gamepatch.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGamePatchInput implements OperationInput {

    private Long id;
    private String description;
}
