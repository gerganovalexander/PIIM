package com.tinqin.academy.api.gamepatch.create;

import com.tinqin.academy.api.generics.OperationInput;
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
