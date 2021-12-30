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

    @Autowired
    private IBookBorrowRepository bookBorrowRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    //class Optional là obj generic -> tránh lỗi NullPointerException
    public Optional<Book> findById(Integer id) throws Exception {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            throw new Exception("Not found!");
        }
        return bookOptional;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void addBorrow(Book book) {
//        status.setId(1);
        BookBorrow bookBorrow = new BookBorrow();
        //mã số mượn sách ngẫu nhiên gồm 5 chữ số.
        int n = new Random().nextInt(5);
        bookBorrow.setBook(book);
        bookBorrow.setCode(n);
        System.out.println(bookBorrow);
        bookBorrowRepository.save(bookBorrow);
    }
}
