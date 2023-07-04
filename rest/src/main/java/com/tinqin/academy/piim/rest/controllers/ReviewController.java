package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.review.create.CreateReviewInput;
import com.tinqin.academy.piim.api.review.create.CreateReviewOperation;
import com.tinqin.academy.piim.api.review.create.CreateReviewResult;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewInput;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewOperation;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewResult;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewInput;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewOperation;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewResult;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsInput;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsOperation;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsResult;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewInput;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewOperation;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdInput;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdOperation;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdResult;
import com.tinqin.academy.piim.api.review.update.UpdateReviewInput;
import com.tinqin.academy.piim.api.review.update.UpdateReviewOperation;
import com.tinqin.academy.piim.api.review.update.UpdateReviewResult;
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
    private final GetAllReviewsOperation getAllReviewsOperation;
    private final GetReviewsByGameIdOperation getReviewsByGameIdOperation;
    private final ExistsByIdReviewOperation existsByIdReviewOperation;

    @GetMapping("/{id}")
    public GetByIdReviewResult getById(@PathVariable @Valid long id) {
        return getByIdReviewOperation.process(
                GetByIdReviewInput.builder().id(id).build());
    }

    @GetMapping
    public GetAllReviewsResult getAll() {
        return getAllReviewsOperation.process(new GetAllReviewsInput());
    }

    @GetMapping(params = "gameId")
    public GetReviewsByGameIdResult getReviewsByGameId(@RequestParam Long gameId) {
        return getReviewsByGameIdOperation.process(new GetReviewsByGameIdInput(gameId));
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

    @GetMapping("/{id}/exists")
    public ExistsByIdReviewResult checkIfReviewExistsById(@PathVariable Long id) {
        return existsByIdReviewOperation.process(
                ExistsByIdReviewInput.builder().id(id).build());
    }
}
