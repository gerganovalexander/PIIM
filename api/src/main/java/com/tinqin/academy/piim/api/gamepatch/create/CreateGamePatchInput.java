package com.tinqin.academy.piim.api.gamepatch.create;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGamePatchInput implements OperationInput {

    private String version;
    private String description;
    private Long gameId;
}
