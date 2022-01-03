package com.blog_app.repository;

import com.blog_app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="iCategoryRepository")
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
