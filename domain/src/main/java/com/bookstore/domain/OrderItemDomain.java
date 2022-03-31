package com.bookstore.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderItemDomain {
    private BookDomain book;
    private Integer quantity;
}
