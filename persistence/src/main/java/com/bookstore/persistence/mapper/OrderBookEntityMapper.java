package com.bookstore.persistence.mapper;

import com.bookstore.domain.OrderItemDomain;
import com.bookstore.persistence.entity.OrderBookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BookEntityMapper.class})
public interface OrderBookEntityMapper extends BaseEntityMapper<OrderBookEntity, OrderItemDomain> {
}
