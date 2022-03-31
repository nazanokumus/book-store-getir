package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.adapter.StockAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.domain.StockDomain;
import com.bookstore.restapi.domain.StockDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import com.bookstore.restapi.enums.ErrorCodeEnum;
import com.bookstore.restapi.exception.CustomRuntimeException;
import com.bookstore.restapi.mapper.StockDtoMapper;
import com.bookstore.restapi.service.StockService;
import com.bookstore.restapi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockAdapter adapter;
    private final BookAdapter bookAdapter;
    private final StockDtoMapper mapper;

    @Override
    public ResponseWrapper<StockDto> updateBookOfStock(UpdateStockRequestDto request) {
        Optional<BookDomain> book = bookAdapter.getBookById(request.getBookId());
        book.orElseThrow(() -> new CustomRuntimeException(ErrorCodeEnum.CONTENT_NOT_FOUND));

        StockDomain stockDomain = mapper.toDomainObjectFromRequest(request);
        Optional<StockDomain> updateStockResult = adapter.updateStockOfBook(stockDomain);
        updateStockResult.orElseThrow(() -> new CustomRuntimeException(ErrorCodeEnum.STOCK_RECORD_NOT_FOUND));

        StockDto stockDto = mapper.toDTO(updateStockResult.get());
        return ResponseUtil.buildSuccess(stockDto);
    }

    @Override
    public ResponseWrapper<List<StockDto>> getAllStock() {
        List<StockDto> stocks = adapter.getAllBookOfStock().stream().map(mapper::toDTO).collect(Collectors.toList());
        return ResponseUtil.buildSuccess(stocks);
    }

    @Override
    public ResponseWrapper<StockDto> getStockByBookId(String bookId) {
        StockDto stocks = adapter.getStockOfBook(bookId).map(mapper::toDTO).get();
        return ResponseUtil.buildSuccess(stocks);
    }
}
