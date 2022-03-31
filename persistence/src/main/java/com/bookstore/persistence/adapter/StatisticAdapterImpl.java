package com.bookstore.persistence.adapter;

import com.bookstore.adapter.StatisticAdapter;
import com.bookstore.domain.StatisticDomain;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class StatisticAdapterImpl implements StatisticAdapter {

    private final OrderRepository repository;

    @Override
    public List<StatisticDomain> groupMonthlyByCustomerId(String customerId) {
        AggregationResults<StatisticDomain> statisticResult = repository.groupMonthlyByCustomerId(customerId);
        return statisticResult.getMappedResults();
    }
}
