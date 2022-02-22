package c0821g1.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_type_id")
    private Integer questionTypeId;
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(targetEntity = Question.class, mappedBy = "questionType", cascade = CascadeType.ALL)
    private List< Question > questionList;

    public QuestionType() {
    }

    public QuestionType(Integer questionTypeId, String name, List<Question> questionList) {
        this.questionTypeId = questionTypeId;
        this.name = name;
        this.questionList = questionList;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
