package com.tinqin.academy.piim.api.review.delete;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteReviewResult implements OperationResult {
    Boolean success;
}
