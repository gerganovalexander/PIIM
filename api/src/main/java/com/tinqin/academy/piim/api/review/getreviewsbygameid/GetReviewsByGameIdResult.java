package com.tinqin.academy.piim.api.review.getreviewsbygameid;

import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetReviewsByGameIdResult implements OperationResult {
    List<ReviewOutput> reviews;
}
