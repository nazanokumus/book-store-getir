package com.bookstore.persistence.adapter;

import com.bookstore.adapter.StockAdapter;
import com.bookstore.domain.StockDomain;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.entity.StockEntity;
import com.bookstore.persistence.mapper.StockEntityMapper;
import com.bookstore.persistence.repository.StockRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class StockAdapterImpl implements StockAdapter {

    private final StockRepository repository;
    private final StockEntityMapper mapper;

    @Override
    public Optional<StockDomain> updateStockOfBook(StockDomain stockOfBook) {

        Optional<StockEntity> stockEntity = repository.findStockEntityByBookId(stockOfBook.getBookId());
        if (!stockEntity.isPresent()) return Optional.empty();


        stockEntity.get().setStock(stockOfBook.getStock());
        repository.save(stockEntity.get());
        return Optional.of(mapper.toDomainObject(stockEntity.get()));
    }

    @Override
    public Optional<StockDomain> createStockOfBook(StockDomain stockOfBook) {
        StockEntity entity = repository.save(mapper.toEntity(stockOfBook));
        return Optional.of(mapper.toDomainObject(entity));
    }


    @Override
    public List<StockDomain> updateStockOfMultipleBook(List<StockDomain> stockOfBookList) {
        List<StockEntity> stockEntities = mapper.toListEntity(stockOfBookList);
        return repository.saveAll(stockEntities).stream().map(mapper::toDomainObject).collect(Collectors.toList());
    }

    @Override
    public Optional<StockDomain> getStockOfBook(String bookId) {
        Optional<StockEntity> stockOfBook = repository.findStockEntityByBookId(bookId);
        return stockOfBook.stream().map(mapper::toDomainObject).findFirst();
    }

    @Override
    public List<StockDomain> getAllBookOfStock() {
        return repository.findAll().stream().map(mapper::toDomainObject).collect(Collectors.toList());
    }
}
