package com.tinqin.academy.piim.api.review.delete;

import com.tinqin.academy.piim.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteReviewInput implements OperationInput {
    private Long id;
}
