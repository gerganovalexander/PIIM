package com.tinqin.academy.api.game.getbyname;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameGameInput implements OperationInput {
    private String name;
}