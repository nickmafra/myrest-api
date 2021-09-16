package com.nickmafra.myrest.client;

import com.nickmafra.myrest.api.model.GetProductsRequest;
import com.nickmafra.myrest.api.model.GetProductsResponse;
import com.nickmafra.myrest.api.service.ProductsApiService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@FeignClient(name = "ProductsApiService", url = "${myrest.api.url}")
public interface ProductsApiClient extends ProductsApiService {

    @Override // force @SpringQueryMap
    @GetMapping
    GetProductsResponse findAll(@SpringQueryMap @Valid GetProductsRequest request);
}
