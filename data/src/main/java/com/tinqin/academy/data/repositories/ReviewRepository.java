package com.tinqin.academy.data.repositories;

import com.tinqin.academy.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
