package com.bookstore.persistence.mapper;

import com.bookstore.domain.CustomerDomain;
import com.bookstore.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper extends BaseEntityMapper<CustomerEntity, CustomerDomain> {
}
