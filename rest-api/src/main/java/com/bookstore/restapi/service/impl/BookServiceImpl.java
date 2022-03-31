package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.adapter.StockAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.domain.StockDomain;
import com.bookstore.restapi.domain.BookDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import com.bookstore.restapi.mapper.BookDtoMapper;
import com.bookstore.restapi.service.BookService;
import com.bookstore.restapi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookAdapter bookAdapter;
    private final StockAdapter stockAdapter;
    private final BookDtoMapper mapper;

    @Override
    public ResponseWrapper<BookDto> createBook(BookDto request) {
        BookDomain bookDomain = mapper.toDomainObject(request);
        BookDomain result = bookAdapter.saveBook(bookDomain);
        // TODO : get stock info from request
        StockDomain stockDomain = new StockDomain(result.getId(), 0);
        stockAdapter.createStockOfBook(stockDomain);

        return ResponseUtil.buildSuccess(mapper.toDTO(result));
    }

    @Override
    public ResponseWrapper<List<BookDto>> getAllBook() {
        List<BookDto> bookList = bookAdapter.getAllBook().stream().map(mapper::toDTO).collect(Collectors.toList());
        return ResponseUtil.buildSuccess(bookList);
    }
}
