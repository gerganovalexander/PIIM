package com.tinqin.academy.piim.api.game.existsbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExistsByIdGameInput implements OperationInput {
    private Long id;
}
