package c0821g1.exam.service;

import c0821g1.exam.model.Question;
import c0821g1.exam.model.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> getAll();
}
