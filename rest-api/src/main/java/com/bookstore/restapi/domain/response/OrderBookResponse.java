package com.bookstore.restapi.domain.response;

import com.bookstore.restapi.domain.BookDto;
import lombok.Data;

@Data
public class OrderBookResponse {
    private BookDto book;
    private Integer quantity;
}
