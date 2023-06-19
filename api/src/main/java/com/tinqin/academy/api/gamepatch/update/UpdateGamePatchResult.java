package com.tinqin.academy.api.gamepatch.update;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGamePatchResult implements OperationResult {
    private GamePatchOutput gamePatchOutput;
}
