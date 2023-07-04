package com.tinqin.academy.piim.api.game.existsbyid;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExistsByIdGameResult implements OperationResult {
    private Boolean doesExist;
}
