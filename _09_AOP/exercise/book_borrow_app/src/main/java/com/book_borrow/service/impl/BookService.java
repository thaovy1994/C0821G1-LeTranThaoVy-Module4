package com.book_borrow.service.impl;

import com.book_borrow.model.Book;
import com.book_borrow.model.BookBorrow;
import com.book_borrow.repository.IBookBorrowRepository;
import com.book_borrow.repository.IBookRepository;
import com.book_borrow.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    //class Optional là obj generic -> tránh lỗi NullPointerException
//    public Optional<Book> findById(Integer id) throws Exception {
//        Optional<Book> bookOptional = bookRepository.findById(id);
//        if (!bookOptional.isPresent()) {
//            throw new Exception("Not found!");
//        }
//        return bookOptional;
//    }
    public Book findById(Integer id){
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }

}
