package blog_app.repository;

import blog_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {  //obj và khóa chính của obj đó
    //Câu lệnh SQL -> nativeQuery = true
    //    @Query(value = "select  * from blog where name like?1", nativeQuery = true)
    //hoặc viết:
//    @Query(value = "select  * from blog where name like: name", nativeQuery = true)
//        List<Blog> getByName(@Param("name") String name);
    // or dùng cách dưới
//    List<Blog> findAllByNameContaining(String name);
}
