package com.blog_app.blog_app_restful.repository;

import com.blog_app.blog_app_restful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="iBlogRepository")
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select  * from blog where name like :name", nativeQuery = true)
    List<Blog> getByName(@Param("name") String name);
}