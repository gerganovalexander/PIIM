package com.tinqin.academy.api.game.delete;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteGameResult implements OperationResult {

    private Boolean success;
}
