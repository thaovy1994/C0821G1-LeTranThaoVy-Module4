package com.book_borrow.model;

import javax.persistence.*;

@Entity(name = "book_borrow")
public class BookBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Integer id;
    @Column
    private String code;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public BookBorrow() {
    }

    public BookBorrow(String code, Book book) {
        this.code = code;
        this.book = book;
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

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
