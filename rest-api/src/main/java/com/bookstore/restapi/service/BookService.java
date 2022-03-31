package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.BookDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;

import java.util.List;

public interface BookService {
    ResponseWrapper<BookDto> createBook(BookDto request);

    ResponseWrapper<List<BookDto>> getAllBook();
}
