package com.tinqin.academy.piim.api.review.getall;

import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllReviewsResult implements OperationResult {
    List<ReviewOutput> reviews;
}
