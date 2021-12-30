package com.book_borrow.repository;

import com.book_borrow.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowRepository extends JpaRepository<BookBorrow,Integer> {
}
