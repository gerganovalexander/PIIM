package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.review.create.CreateReviewInput;
import com.tinqin.academy.piim.api.review.create.CreateReviewOperation;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewInput;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewOperation;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewInput;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewOperation;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsInput;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsOperation;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewInput;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewOperation;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdInput;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdOperation;
import com.tinqin.academy.piim.api.review.update.UpdateReviewInput;
import com.tinqin.academy.piim.api.review.update.UpdateReviewOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController extends BaseController {

    private final CreateReviewOperation createReviewOperation;
    private final UpdateReviewOperation updateReviewOperation;
    private final DeleteReviewOperation deleteReviewOperation;
    private final GetByIdReviewOperation getByIdReviewOperation;
    private final GetAllReviewsOperation getAllReviewsOperation;
    private final GetReviewsByGameIdOperation getReviewsByGameIdOperation;
    private final ExistsByIdReviewOperation existsByIdReviewOperation;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @Valid long id) {
        return handleOperation(getByIdReviewOperation.process(
                GetByIdReviewInput.builder().id(id).build()));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return handleOperation(getAllReviewsOperation.process(new GetAllReviewsInput()));
    }

    @GetMapping(params = "gameId")
    public ResponseEntity<?> getReviewsByGameId(@RequestParam Long gameId) {
        return handleOperation(getReviewsByGameIdOperation.process(new GetReviewsByGameIdInput(gameId)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateReviewInput review) {
        return handleOperation(createReviewOperation.process(review));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid UpdateReviewInput review) {
        review.setId(id);
        return handleOperation(updateReviewOperation.process(review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return handleOperation(
                deleteReviewOperation.process(DeleteReviewInput.builder().id(id).build()));
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<?> checkIfReviewExistsById(@PathVariable Long id) {
        return handleOperation(existsByIdReviewOperation.process(
                ExistsByIdReviewInput.builder().id(id).build()));
    }
}
