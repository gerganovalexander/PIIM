package com.tinqin.academy.api.review.create;

import com.tinqin.academy.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.api.generics.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewResult implements OperationResult {
    private ReviewOutput reviewOutput;

}
