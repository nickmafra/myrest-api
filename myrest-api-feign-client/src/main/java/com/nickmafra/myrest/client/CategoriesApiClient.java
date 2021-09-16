package com.nickmafra.myrest.client;

import com.nickmafra.myrest.api.model.GetCategoriesRequest;
import com.nickmafra.myrest.api.model.GetCategoriesResponse;
import com.nickmafra.myrest.api.service.CategoriesApiService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@FeignClient(name = "CategoriesApiService", url = "${myrest.api.url}")
public interface CategoriesApiClient extends CategoriesApiService {

    @Override // force @SpringQueryMap
    @GetMapping
    GetCategoriesResponse findAll(@SpringQueryMap @Valid GetCategoriesRequest request);
}
