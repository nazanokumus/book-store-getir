package com.bookstore.persistence.adapter;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.entity.BookEntity;
import com.bookstore.persistence.mapper.BookEntityMapper;
import com.bookstore.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class BookAdapterImpl implements BookAdapter {

    private final BookRepository repository;
    private final BookEntityMapper mapper;

    @Override
    public BookDomain saveBook(BookDomain request) {
        BookEntity bookEntity = mapper.toEntity(request);
        return mapper.toDomainObject(repository.save(bookEntity));
    }

    @Override
    public List<BookDomain> getAllBook() {
        return repository.findAll().stream().map(mapper::toDomainObject).collect(Collectors.toList());
    }

    @Override
    public Optional<BookDomain> getBookById(String bookId) {
        return repository.findById(bookId).stream().map(mapper::toDomainObject).findFirst();
    }
}
