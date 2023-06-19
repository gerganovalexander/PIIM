package com.tinqin.academy.piim.api.game.delete;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteGameResult implements OperationResult {

    private Boolean success;
}
