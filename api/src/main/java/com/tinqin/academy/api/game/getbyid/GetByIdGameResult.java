package com.tinqin.academy.api.game.getbyid;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdGameResult implements OperationResult {

    private Long id;

    private String name;

    private String avgReviewDescription;

    private LocalDateTime releaseDate;

    private String publisher;
}
