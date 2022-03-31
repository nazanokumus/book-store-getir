package com.bookstore.persistence.mapper;

import com.bookstore.domain.StockDomain;
import com.bookstore.persistence.entity.StockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockEntityMapper extends BaseEntityMapper<StockEntity, StockDomain> {
}
