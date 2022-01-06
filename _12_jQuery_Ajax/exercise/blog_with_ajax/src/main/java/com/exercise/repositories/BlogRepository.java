package com.exercise.repositories;

import com.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value ="SELECT * FROM blog WHERE blog.name like concat('%', ?1, '%') LIMIT ?2 , 2;", nativeQuery=true)
    List<Blog> searchByName(String name, int offset);
}
