package com.tinqin.academy.api.game.getbyid;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdGameInput implements OperationInput {

    private Long id;
}
