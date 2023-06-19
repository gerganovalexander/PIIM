package com.tinqin.academy.api.game.create;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGameInput implements OperationInput {

    private String name;

    private LocalDateTime releaseDate;

    private String publisher;
}
