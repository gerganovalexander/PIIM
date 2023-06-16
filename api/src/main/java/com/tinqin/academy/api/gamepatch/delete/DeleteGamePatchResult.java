package com.tinqin.academy.api.gamepatch.delete;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteGamePatchResult implements OperationResult {
    boolean success;
}
