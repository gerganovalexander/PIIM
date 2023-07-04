package com.tinqin.academy.piim.api.review.existsbyid;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExistsByIdReviewInput implements OperationInput {
    private Long id;
}
