package com.tinqin.academy.piim.api.game.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteGameInput implements OperationInput {

    private Long id;
}
