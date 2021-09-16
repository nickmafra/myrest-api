package com.nickmafra.myrest.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetProductsRequest extends PageRequest {
    @Positive
    Integer categoryId;
    @Positive
    BigDecimal maxPrice;
}
