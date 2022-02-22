package c0821g1.exam.service.impl;

import c0821g1.exam.dto.QuestionDto;
import c0821g1.exam.model.Question;
import c0821g1.exam.repository.IQuestionRepository;
import c0821g1.exam.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

//    @Override
//    public Page<Question> findByTitle(Pageable pageable, String title) {
//        Page<Question> questionPage = questionRepository.getByTitle(pageable, "%" + title + "%");
//        return questionPage;
//    }

    @Override
    public Page<Question> findByTitleAndQuestionTypePage(String titleNew, String questionTypeNew, Pageable pageable) {
        Page<Question> questionPage = questionRepository.findByTitleAndQuestionTypePage("%" + titleNew + "%","%" + questionTypeNew + "%",pageable);
        return questionPage;
    }


    @Override
    public void save(QuestionDto questionDto) {
        Question question = new Question(questionDto.getId(), questionDto.getTitle(), questionDto.getQuestions(),
                questionDto.getAnswer(), questionDto.getQuestionType(), questionDto.getDate_create(),
                questionDto.getStatus());
        questionRepository.save(question);
    }

    @Override
    public void remove(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAll(Pageable of) {
        return questionRepository.findAll(of);
    }
}
