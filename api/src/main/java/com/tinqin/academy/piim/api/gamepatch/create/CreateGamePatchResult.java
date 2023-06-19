package com.tinqin.academy.piim.api.gamepatch.create;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGamePatchResult implements OperationResult {
    private GamePatchOutput gamePatchOutput;
}
