package com.bookstore.restapi.domain.request;

import lombok.Data;

@Data
public class OrderItemDto {
    private String bookId;
    private Integer quantity;
}
