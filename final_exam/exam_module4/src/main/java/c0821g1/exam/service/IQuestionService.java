package c0821g1.exam.service;

import c0821g1.exam.dto.QuestionDto;
import c0821g1.exam.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
    List<Question> getAll();

    Question findById(Integer id);

//    Page<Question> findByTitle(Pageable pageable, String title);

    Page<Question> findByTitleAndQuestionTypePage(String titleNew, String questionTypeNew, Pageable pageable);

    void save(QuestionDto questionDto);

    void remove(Integer id);

    Page<Question> findAll(Pageable of);
}
