package com.tinqin.academy.piim.api.game.update;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateGameInput implements OperationInput {

    private Long id;

    private String name;

    private LocalDateTime releaseDate;

    private String publisher;
}
