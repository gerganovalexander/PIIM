package com.tinqin.academy.api.review.getbyid;

import com.tinqin.academy.api.entityoutputmodels.UserOutput;
import com.tinqin.academy.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdReviewResult implements OperationResult {
    private Long id;
    private String text;
    private Integer score;
    private UserOutput userOutput;
}
