package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookEntity, String> {
}
