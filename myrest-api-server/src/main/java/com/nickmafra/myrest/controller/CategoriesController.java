package com.nickmafra.myrest.controller;

import com.nickmafra.myrest.api.model.Category;
import com.nickmafra.myrest.api.model.GetCategoriesRequest;
import com.nickmafra.myrest.api.model.GetCategoriesResponse;
import com.nickmafra.myrest.api.service.CategoriesApiService;
import com.nickmafra.myrest.mock.CategoryMock;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.nickmafra.myrest.utils.PageUtils.pageFilter;
import static com.nickmafra.myrest.utils.PageUtils.withValues;

@RestController
public class CategoriesController implements CategoriesApiService {

    @Override
    public Category findById(long id) {
        return CategoryMock.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public GetCategoriesResponse findAll(@Valid GetCategoriesRequest request) {
        List<Category> allContent = CategoryMock.stream().collect(Collectors.toList());
        return withValues(new GetCategoriesResponse(), new GetCategoriesRequest(), pageFilter(new GetCategoriesRequest(), allContent));
    }
}
