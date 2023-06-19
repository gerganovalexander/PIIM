package com.tinqin.academy.piim.api.game.getbyname;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameGameInput implements OperationInput {
    private String name;
}