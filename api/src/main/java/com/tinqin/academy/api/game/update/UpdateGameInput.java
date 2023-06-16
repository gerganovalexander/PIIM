package com.tinqin.academy.api.game.update;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGameInput implements OperationInput {

    private Long id;

    private String name;

    private LocalDateTime releaseDate;

    private String publisher;
}
