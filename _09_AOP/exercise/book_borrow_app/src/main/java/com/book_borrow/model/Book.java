package com.book_borrow.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer number;

    @OneToMany(targetEntity = BookBorrow.class, mappedBy ="book")
    List<BookBorrow> bookBorrowList;

    public List<BookBorrow> getBookBorrowList() {
        return bookBorrowList;
    }

    public void setBookBorrowList(List<BookBorrow> bookBorrowList) {
        this.bookBorrowList = bookBorrowList;
    }

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
