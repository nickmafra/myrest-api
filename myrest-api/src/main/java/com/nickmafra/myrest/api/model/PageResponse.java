package com.nickmafra.myrest.api.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public abstract class PageResponse<T> {
    int offset;
    int size;
    int total;
    List<T> content;
}
