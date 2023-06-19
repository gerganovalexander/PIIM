package com.tinqin.academy.piim.api.game.getbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdGameInput implements OperationInput {

    private Long id;
}
