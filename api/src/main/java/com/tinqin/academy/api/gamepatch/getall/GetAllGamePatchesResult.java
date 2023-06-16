package com.tinqin.academy.api.gamepatch.getall;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllGamePatchesResult {

    private GamePatchOutput gamePatch;

}
