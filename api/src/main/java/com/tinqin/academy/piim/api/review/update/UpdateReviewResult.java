package com.tinqin.academy.piim.api.review.update;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateReviewResult implements OperationResult {
    private Long id;
    private String text;
}
