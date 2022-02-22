package c0821g1.exam.service.impl;

import c0821g1.exam.model.Question;
import c0821g1.exam.model.QuestionType;
import c0821g1.exam.repository.IQuestionTypeRepository;
import c0821g1.exam.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> getAll() {
        return questionTypeRepository.findAll();
    }
}
