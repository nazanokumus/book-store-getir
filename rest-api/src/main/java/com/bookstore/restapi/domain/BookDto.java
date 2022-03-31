package com.bookstore.restapi.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class BookDto extends BaseDto{
    @NotNull
    private String title;
    @NotNull
    private String author;
    private String description;
    @NotNull
    private BigDecimal price;
}
