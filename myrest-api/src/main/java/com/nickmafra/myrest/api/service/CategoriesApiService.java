package com.nickmafra.myrest.api.service;

import com.nickmafra.myrest.api.model.Category;
import com.nickmafra.myrest.api.model.GetCategoriesRequest;
import com.nickmafra.myrest.api.model.GetCategoriesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/categories")
public interface CategoriesApiService {

    @GetMapping("/{id}")
    Category findById(@PathVariable("id") long id);

    @GetMapping("/find")
    GetCategoriesResponse findAll(@Valid GetCategoriesRequest request);
}
