package com.book_borrow.service;

import com.book_borrow.model.Book;
import com.book_borrow.model.BookBorrow;

import java.util.List;
import java.util.Optional;

public interface IBookBorrowService {
    List<BookBorrow> findAll();

    //Optional<BookBorrow> findById(Integer id);
    BookBorrow findById(Integer id);

    BookBorrow findByCode(String code);

    void save(BookBorrow bookBorrow);

    void remove(Integer id);

    void addBorrow(BookBorrow bookBorrow);

    Boolean returnBook(Book book, int code);
}
