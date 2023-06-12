package com.tinqin.academy.piim.controllers;

import com.tinqin.academy.piim.dtos.CategoryDto;
import com.tinqin.academy.piim.models.Category;
import com.tinqin.academy.piim.services.contracts.CategoryService;
import com.tinqin.academy.piim.utils.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.tinqin.academy.piim.utils.CategoryMapper.categoryToDto;
import static com.tinqin.academy.piim.utils.CategoryMapper.dtoToCategory;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

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
    public CategoryDto create(@RequestBody @Valid CategoryDto category) {
        return categoryToDto(categoryService.create(dtoToCategory(category)));
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable long id, @RequestBody @Valid CategoryDto category) {
        return categoryToDto(categoryService.update(dtoToCategory(category, id)));
    }

    @DeleteMapping("/{id}")
    public CategoryDto update(@PathVariable long id) {
        Category category = categoryService.getById(id);
        categoryService.delete(id);
        return categoryToDto(category);
    }
}
