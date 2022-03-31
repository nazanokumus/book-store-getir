package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.StatisticDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;

import java.util.List;

public interface StatisticService {
    ResponseWrapper<List<StatisticDto>> getMonthlyStatistic(String customerId);
}
