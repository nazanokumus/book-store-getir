package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.StockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StockRepository extends MongoRepository<StockEntity, String> {
    Optional<StockEntity> findStockEntityByBookId(String bookId);
}
