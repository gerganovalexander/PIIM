package com.tinqin.academy.piim.api.gamepatch.delete;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteGamePatchResult implements OperationResult {
    boolean success;
}
