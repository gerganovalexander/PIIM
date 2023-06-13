package com.tinqin.academy.business.services;

import com.tinqin.academy.business.exceptions.DuplicateEntityException;
import com.tinqin.academy.business.services.contracts.CategoryService;
import com.tinqin.academy.data.models.Category;
import com.tinqin.academy.data.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Category with id %d not found.", id)));
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findFirstByName(name).orElseThrow(
                () -> new EntityNotFoundException(String.format("Category with name %s not found.", name)));
    }

    @Override
    public Category create(Category category) {
        if (categoryRepository.existsByName(category.getName()))
            throw new DuplicateEntityException("Category", "name", category.getName());

        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        if (category.getId() <= 0) throw new InvalidParameterException("Category id is invalid.");
        if (categoryRepository.existsByName(category.getName()))
            throw new DuplicateEntityException("Category", "name", category.getName());

        return categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
        if (id <= 0) throw new InvalidParameterException("Category id is invalid.");

        categoryRepository.deleteById(id);
    }
}