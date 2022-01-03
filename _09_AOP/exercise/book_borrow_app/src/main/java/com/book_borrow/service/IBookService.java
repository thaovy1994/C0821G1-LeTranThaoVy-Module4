package com.book_borrow.service;

import com.book_borrow.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

//    Optional<Book> findById(Integer id) throws Exception;
    Book findById(Integer id);

    void save(Book book);

    void remove(Integer id);
}
