package com.bookstore.persistence.mapper;

import com.bookstore.domain.OrderDomain;
import com.bookstore.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderBookEntityMapper.class})
public interface OrderEntityMapper extends BaseEntityMapper<OrderEntity, OrderDomain> {
}
