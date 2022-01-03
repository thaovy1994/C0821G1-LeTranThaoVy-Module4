package com.book_borrow.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private Integer quantity;

    @OneToMany(targetEntity = BookBorrow.class, mappedBy = "book", cascade = CascadeType.ALL)
//    List<BookBorrow> bookBorrowList;
    private Set<BookBorrow> codeSet;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer quantity, Set<BookBorrow> codeSet) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.codeSet = codeSet;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<BookBorrow> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(Set<BookBorrow> codeSet) {
        this.codeSet = codeSet;
    }
}
