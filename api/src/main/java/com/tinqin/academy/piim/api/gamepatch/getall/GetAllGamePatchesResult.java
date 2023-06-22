package com.tinqin.academy.piim.api.gamepatch.getall;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllGamePatchesResult {

    private GamePatchOutput gamePatch;
}
