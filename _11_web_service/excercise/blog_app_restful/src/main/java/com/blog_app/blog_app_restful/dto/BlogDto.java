package com.blog_app.blog_app_restful.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogDto {
    private Integer id;

    private String name;

    private String content;

    private String note;

//    @ManyToOne(targetEntity = Category.class)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public BlogDto() {
    }

    public BlogDto(Integer id, String name, String content, String note) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.note = note;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
