package com.tinqin.academy.api.game.getbyname;

import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByNameGameResult implements OperationResult {

    private Long id;

    private String name;

    private String avgReviewDescription;

    private LocalDateTime releaseDate;

    private String publisher;
}
