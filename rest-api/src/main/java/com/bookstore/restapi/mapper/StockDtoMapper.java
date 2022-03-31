package com.bookstore.restapi.mapper;

import com.bookstore.domain.StockDomain;
import com.bookstore.restapi.domain.StockDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockDtoMapper extends BaseDtoMapper<StockDomain, StockDto> {

    StockDomain toDomainObjectFromRequest(UpdateStockRequestDto request);
}
