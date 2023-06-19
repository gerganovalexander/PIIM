package com.tinqin.academy.api.gamepatch.getbyid;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetGamePatchByIdResult implements OperationResult {

    private GamePatchOutput gamePatch;

}
