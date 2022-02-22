package c0821g1.exam.repository;

import c0821g1.exam.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {
//    @Query(value = "select  * from question where title like :title", nativeQuery = true)
//    Page<Question> getByTitle(Pageable pageable, @Param("title") String title);

    @Query(value = "select question.id,question.answer,question.date_create,question.questions,question.question_type_id,question.title,question.status\n" +
            "from test_question.question\n" +
            "join test_question.question_type on question.question_type_id = question_type.question_type_id\n" +
            "where question.title like :titleNew and question_type.name like :questionTypeNew", nativeQuery = true)
    Page<Question> findByTitleAndQuestionTypePage(@Param("titleNew") String titleNew,
                                                  @Param("questionTypeNew") String questionTypeNew, Pageable pageable);
}
