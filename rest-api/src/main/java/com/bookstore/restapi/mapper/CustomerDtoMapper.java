package com.bookstore.restapi.mapper;

import com.bookstore.domain.CustomerDomain;
import com.bookstore.restapi.domain.CustomerDto;
import com.bookstore.restapi.domain.request.CustomerRegisterDto;
import com.bookstore.restapi.util.Helper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper extends BaseDtoMapper<CustomerDomain, CustomerDto> {

    @Mapping(target = "encryptedPassword", source = "password", qualifiedByName = "encryptValue")
    CustomerDomain toDomainObjectFromLogin(CustomerRegisterDto registerRequest);

    @Named("encryptValue")
    default String encryptValue(String password){
        return Helper.encryptionValue(password);
    }


}
