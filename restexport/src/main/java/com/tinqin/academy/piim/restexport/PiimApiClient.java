package com.tinqin.academy.piim.restexport;

import com.tinqin.academy.piim.api.category.getall.GetAllCategoryResults;
import feign.Headers;
import org.springframework.web.bind.annotation.GetMapping;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface PiimApiClient {
    @GetMapping("/api/categories")
    GetAllCategoryResults getAllCategories();
}
