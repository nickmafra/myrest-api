package com.nickmafra.myrest.mock;

import com.nickmafra.myrest.api.model.Category;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum CategoryMock {
    ESCRITORIO(new Category(1, "Escritório")),
    COZINHA(new Category(2, "Cozinha")),
    ;
    private final Category value;

    public static Stream<Category> stream() {
        return Stream.of(values()).map(CategoryMock::getValue);
    }
}
