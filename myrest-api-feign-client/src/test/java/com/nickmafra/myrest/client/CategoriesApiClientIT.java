package com.nickmafra.myrest.client;

import com.nickmafra.myrest.api.model.Category;
import com.nickmafra.myrest.api.model.GetCategoriesRequest;
import com.nickmafra.myrest.api.model.GetCategoriesResponse;
import com.nickmafra.myrest.api.service.CategoriesApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoriesApiClientIT {

    @Autowired
    CategoriesApiService categoriesApiService;

    @Test
    void testFindById() {
        Category category = categoriesApiService.findById(1);
        assertThat(category).isNotNull();
    }

    @Test
    void testFindAll() {
        GetCategoriesResponse response = categoriesApiService.findAll(new GetCategoriesRequest());
        assertThat(response).isNotNull();
        assertThat(response.getContent()).isNotEmpty();
    }
}