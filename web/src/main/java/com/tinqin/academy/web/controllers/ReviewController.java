package com.tinqin.academy.web.controllers;

import com.tinqin.academy.business.dtos.ReviewDto;
import com.tinqin.academy.business.mappers.ReviewMapper;
import com.tinqin.academy.business.services.contracts.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.tinqin.academy.business.mappers.ReviewMapper.dtoToReview;
import static com.tinqin.academy.business.mappers.ReviewMapper.reviewToDto;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<ReviewDto> reviewList = reviewService.getAllReviews().stream()
                .map(ReviewMapper::reviewToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable long id) {
        ReviewDto review = reviewToDto(reviewService.getReviewById(id));
        return ResponseEntity.ok(review);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto review) {
        ReviewDto createdReview = reviewToDto(reviewService.createReview(dtoToReview(review)));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id, @RequestBody ReviewDto review) {
        ReviewDto updatedReview = reviewToDto(reviewService.updateReview(id, dtoToReview(review, id)));
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }


}
