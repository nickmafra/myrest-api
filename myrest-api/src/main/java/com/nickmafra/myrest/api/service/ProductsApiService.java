package com.nickmafra.myrest.api.service;

import com.nickmafra.myrest.api.model.GetProductsRequest;
import com.nickmafra.myrest.api.model.GetProductsResponse;
import com.nickmafra.myrest.api.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@RequestMapping("/products")
public interface ProductsApiService {

    @GetMapping("/{id}")
    Product findById(@PathVariable("id") long id);

    @GetMapping
    GetProductsResponse findAll(@Valid GetProductsRequest request);
}
