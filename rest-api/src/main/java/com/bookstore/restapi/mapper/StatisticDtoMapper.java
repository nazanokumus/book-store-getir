package com.bookstore.restapi.mapper;

import com.bookstore.domain.StatisticDomain;
import com.bookstore.restapi.domain.StatisticDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticDtoMapper extends BaseDtoMapper<StatisticDomain, StatisticDto> {
}
