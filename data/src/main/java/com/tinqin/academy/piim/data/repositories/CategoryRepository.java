package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findFirstByName(String name);

    boolean existsByName(String name);
}
