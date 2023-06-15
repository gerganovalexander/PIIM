package com.tinqin.academy.rest.controllers;

import com.tinqin.academy.api.category.create.CreateCategoryInput;
import com.tinqin.academy.api.category.create.CreateCategoryOperation;
import com.tinqin.academy.api.category.create.CreateCategoryResult;
import com.tinqin.academy.api.dtos.CategoryDto;
import com.tinqin.academy.business.mappers.CategoryMapper;
import com.tinqin.academy.business.services.contracts.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.tinqin.academy.business.mappers.CategoryMapper.categoryToDto;
import static com.tinqin.academy.business.mappers.CategoryMapper.dtoToCategory;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CreateCategoryOperation createCategoryOperation;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll()
                .stream()
                .map(CategoryMapper::categoryToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable long id) {
        return categoryToDto(categoryService.getById(id));
    }

    @GetMapping(params = "name")
    public CategoryDto getByName(@RequestParam(name = "name") String name) {
        return categoryToDto(categoryService.getByName(name));
    }

    @PostMapping
    public CreateCategoryResult create(@RequestBody @Valid CreateCategoryInput category) {
        return createCategoryOperation.process(category);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable long id, @RequestBody @Valid CategoryDto category) {
        return categoryToDto(categoryService.update(dtoToCategory(category, id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoryService.delete(id);
    }
}
