package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.StatisticAdapter;
import com.bookstore.domain.StatisticDomain;
import com.bookstore.restapi.domain.StatisticDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import com.bookstore.restapi.mapper.StatisticDtoMapper;
import com.bookstore.restapi.service.StatisticService;
import com.bookstore.restapi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticAdapter adapter;
    private final StatisticDtoMapper mapper;

    @Override
    public ResponseWrapper<List<StatisticDto>> getMonthlyStatistic(String customerId) {
        List<StatisticDomain> statisticResult = adapter.groupMonthlyByCustomerId(customerId);
        return ResponseUtil.buildSuccess(mapper.toListDTO(statisticResult));
    }
}
