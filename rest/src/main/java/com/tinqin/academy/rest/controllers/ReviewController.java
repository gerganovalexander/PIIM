package com.tinqin.academy.rest.controllers;

import com.tinqin.academy.api.review.create.CreateReviewInput;
import com.tinqin.academy.api.review.create.CreateReviewOperation;
import com.tinqin.academy.api.review.create.CreateReviewResult;
import com.tinqin.academy.api.review.delete.DeleteReviewInput;
import com.tinqin.academy.api.review.delete.DeleteReviewOperation;
import com.tinqin.academy.api.review.delete.DeleteReviewResult;
import com.tinqin.academy.api.review.getbyid.GetByIdReviewInput;
import com.tinqin.academy.api.review.getbyid.GetByIdReviewOperation;
import com.tinqin.academy.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.api.review.update.UpdateReviewInput;
import com.tinqin.academy.api.review.update.UpdateReviewOperation;
import com.tinqin.academy.api.review.update.UpdateReviewResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {


    private final CreateReviewOperation createReviewOperation;
    private final UpdateReviewOperation updateReviewOperation;
    private final DeleteReviewOperation deleteReviewOperation;
    private final GetByIdReviewOperation getByIdReviewOperation;

    @GetMapping("/{id}")
    public GetByIdReviewResult getById(@PathVariable @Valid long id) {
        return getByIdReviewOperation.process(GetByIdReviewInput.builder().id(id).build());
    }

    @PostMapping
    public CreateReviewResult create(@RequestBody @Valid CreateReviewInput review) {
        return createReviewOperation.process(review);
    }


    @PutMapping("/{id}")
    public UpdateReviewResult update(@PathVariable long id, @RequestBody @Valid UpdateReviewInput review) {
        review.setId(id);
        return updateReviewOperation.process(review);
    }

    @DeleteMapping("/{id}")
    public DeleteReviewResult delete(@PathVariable long id) {
        return deleteReviewOperation.process(DeleteReviewInput.builder().id(id).build());
    }


}
