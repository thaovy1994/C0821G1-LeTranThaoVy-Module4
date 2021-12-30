package com.book_borrow.model;

import javax.persistence.*;

@Entity(name = "book_borrow")
public class BookBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;

    @ManyToOne(targetEntity = Book.class)
    private Book book;

    public BookBorrow() {
    }

    public BookBorrow(Integer id, String code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
