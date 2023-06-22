package com.tinqin.academy.piim.api.gamepatch.getbyid;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetGamePatchByIdResult implements OperationResult {

    private GamePatchOutput gamePatch;
}
