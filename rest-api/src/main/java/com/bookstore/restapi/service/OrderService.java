package com.bookstore.restapi.service;

import com.bookstore.domain.PageResponse;
import com.bookstore.restapi.domain.OrderDto;
import com.bookstore.restapi.domain.request.OrderItemDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    ResponseWrapper<OrderDto> createOrder(String customerId, List<OrderItemDto> request);

    ResponseWrapper<List<OrderDto>> getOrdersByCustomerId(String customerId);

    ResponseWrapper<OrderDto> getOrdersById(String orderId);

    PageResponse<OrderDto> filterOrdersByDateRange(LocalDate from, LocalDate to, Integer page, Integer size);
}
