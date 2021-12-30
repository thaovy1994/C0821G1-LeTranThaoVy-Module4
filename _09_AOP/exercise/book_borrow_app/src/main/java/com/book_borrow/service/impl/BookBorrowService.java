package com.book_borrow.service.impl;

import com.book_borrow.model.Book;
import com.book_borrow.model.BookBorrow;
import com.book_borrow.repository.IBookBorrowRepository;
import com.book_borrow.repository.IBookRepository;
import com.book_borrow.service.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBookBorrowRepository bookBorrowRepository;

    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAll();
    }

    @Override
    public Optional<BookBorrow> findById(Integer id) {
        return Optional.empty();
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
    //Nếu mã số sai thì sẽ không mượn được và gặp lỗi.
    public Boolean returnBook(Book book, int code) {
        List<BookBorrow> bookBorrowList = bookBorrowRepository.findAll();
        for (BookBorrow bookBorrow : bookBorrowList) {
            if (bookBorrow.getCode().equals(code)) {
                bookBorrowRepository.deleteById(bookBorrow.getId());
                book.setNumber(book.getNumber() + 1);
                bookRepository.save(book);
                return  true;
            }
        }
        return true;
    }
}