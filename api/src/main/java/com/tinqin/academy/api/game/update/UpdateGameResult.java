package com.tinqin.academy.api.game.update;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateGameResult implements OperationResult {

    private Long id;

    private String name;

    private String avgReviewDescription;

    private LocalDateTime releaseDate;

    private String publisher;
}
