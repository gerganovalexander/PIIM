package com.tinqin.academy.piim.services;

import com.tinqin.academy.piim.exceptions.DuplicateEntityException;
import com.tinqin.academy.piim.exceptions.EntityNotFoundException;
import com.tinqin.academy.piim.models.Category;
import com.tinqin.academy.piim.repositories.CategoryRepository;
import com.tinqin.academy.piim.services.contracts.CategoryService;
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
