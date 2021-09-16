package com.nickmafra.myrest.controller;

import com.nickmafra.myrest.api.model.GetProductsRequest;
import com.nickmafra.myrest.api.model.GetProductsResponse;
import com.nickmafra.myrest.api.model.Product;
import com.nickmafra.myrest.api.service.ProductsApiService;
import com.nickmafra.myrest.mock.ProductMock;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.nickmafra.myrest.utils.PageUtils.pageFilter;
import static com.nickmafra.myrest.utils.PageUtils.withValues;

@RestController
public class ProductsController implements ProductsApiService {

    @Override
    public Product findById(long id) {
        return ProductMock.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public GetProductsResponse findAll(@Valid GetProductsRequest request) {
        List<Product> allContent = ProductMock.stream()
                .filter(p -> request.getCategoryId() == null || p.getCategory().getId() == request.getCategoryId())
                .filter(p -> request.getMaxPrice() == null || p.getPrice().compareTo(request.getMaxPrice()) <= 0)
                .collect(Collectors.toList());
        return withValues(new GetProductsResponse(), request, pageFilter(request, allContent));
    }
}
