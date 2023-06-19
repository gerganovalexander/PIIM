package com.tinqin.academy.api.review.delete;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteReviewInput implements OperationInput {
    private Long id;
}
