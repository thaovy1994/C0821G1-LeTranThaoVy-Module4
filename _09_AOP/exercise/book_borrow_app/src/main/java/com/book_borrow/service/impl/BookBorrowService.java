package com.book_borrow.service.impl;

import com.book_borrow.model.Book;
import com.book_borrow.model.BookBorrow;
import com.book_borrow.repository.IBookBorrowRepository;
import com.book_borrow.service.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    private IBookBorrowRepository bookBorrowRepository;

    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAll();
    }

    @Override
//    public Optional<BookBorrow> findById(Integer id) {
//        return Optional.empty();
    public BookBorrow findById(Integer id){
        return bookBorrowRepository.findById(id).orElse(null);
    }

    @Override
    public BookBorrow findByCode(String code) {
        return bookBorrowRepository.findByCodeForBook(code);
    }

    @Override
    public void save(BookBorrow bookBorrow) {
        bookBorrowRepository.save(bookBorrow);
    }

    @Override
    public void remove(Integer id) {
        bookBorrowRepository.deleteById(id);
    }

    @Override
    public void addBorrow(BookBorrow bookBorrow) {

    }

    @Override
    public Boolean returnBook(Book book, int code) {
        return null;
    }
}