package com.tinqin.academy.api.review.getbyid;

import com.tinqin.academy.api.generics.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdReviewInput implements OperationInput {

    private Long id;
}
