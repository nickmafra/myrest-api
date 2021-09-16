package com.nickmafra.myrest.mock;

import com.nickmafra.myrest.api.model.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum ProductMock {
    CADEIRA(new Product(1, "Cadeira de escritório", new BigDecimal("599.99"), CategoryMock.ESCRITORIO.getValue())),
    MESA(new Product(2, "Mesa de escritório", new BigDecimal("299.99"), CategoryMock.ESCRITORIO.getValue())),
    FORNO(new Product(3, "Forno", new BigDecimal("799.99"), CategoryMock.COZINHA.getValue()))
    ;
    private final Product value;

    public static Stream<Product> stream() {
        return Stream.of(values()).map(ProductMock::getValue);
    }
}
