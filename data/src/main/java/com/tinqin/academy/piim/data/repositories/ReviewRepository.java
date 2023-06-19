package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
