package com.tinqin.academy.piim.api.gamepatch.update;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGamePatchResult implements OperationResult {
    private GamePatchOutput gamePatchOutput;
}
