package com.bookstore.restapi.domain.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateStockRequestDto {
    @NotNull
    private String bookId;
    @NotNull
    private Integer stock;
}
