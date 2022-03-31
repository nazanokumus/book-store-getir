package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.StockDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;

import java.util.List;

public interface StockService {
    ResponseWrapper<StockDto> updateBookOfStock(UpdateStockRequestDto request);

    ResponseWrapper<List<StockDto>> getAllStock();

    ResponseWrapper<StockDto> getStockByBookId(String bookId);
}
