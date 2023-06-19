package com.tinqin.academy.api.game.delete;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteGameInput implements OperationInput {

    private Long id;
}
