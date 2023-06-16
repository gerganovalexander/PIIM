package com.tinqin.academy.api.gamepatch.create;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGamePatchResult implements OperationResult {
    private GamePatchOutput gamePatchOutput;
}
