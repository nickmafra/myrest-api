package com.nickmafra.myrest.client;

import com.nickmafra.myrest.api.model.*;
import com.nickmafra.myrest.api.service.CategoriesApiService;
import com.nickmafra.myrest.api.service.ProductsApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductsApiClientIT {

    @Autowired
    ProductsApiService productsApiService;

    @Test
    void testFindById() {
        Product Product = productsApiService.findById(1);
        assertThat(Product).isNotNull();
    }

    @Test
    void testFindAll() {
        GetProductsResponse response = productsApiService.findAll(new GetProductsRequest());
        assertThat(response).isNotNull();
        assertThat(response.getContent()).isNotEmpty();
    }
}