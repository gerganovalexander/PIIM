package com.tinqin.academy.piim.api.review.existsbyid;

import com.tinqin.academy.piim.api.generics.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExistsByIdReviewResult implements OperationResult {
    private Boolean doesExist;
}
