package com.nickmafra.myrest.utils;

import com.nickmafra.myrest.api.model.PageRequest;
import com.nickmafra.myrest.api.model.PageResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PageUtils {
    private PageUtils() {}

    public static <T> List<T> pageFilter(PageRequest request, List<T> allContent) {
        return IntStream.range(0, allContent.size())
                .filter(i -> i >= request.getOffset() && i < request.getOffset() + request.getSize())
                .boxed().map(allContent::get)
                .collect(Collectors.toList());
    }

    public static <T, R extends PageResponse<T>> R withValues(R response, PageRequest request, List<T> content) {
        response.setOffset(request.getOffset());
        response.setSize(request.getSize());
        response.setContent(content);
        return response;
    }
}
