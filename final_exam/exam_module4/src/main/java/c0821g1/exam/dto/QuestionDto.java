package c0821g1.exam.dto;

import c0821g1.exam.model.QuestionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionDto implements Validator {

    private Integer id;
    @NotBlank
    @Size(min=5, max = 100, message = "title must be from 5 to 100 words")
    private String title;
    @NotBlank
    @Size(min=10,max=500, message = "content must be from 10 to 500 words")
    private String questions;
//    @NotBlank
    @Size(min=10,max=500, message = "content must be from 10 to 500 words")
    private String answer;

    @ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "question_type", referencedColumnName = "question_type")
    private QuestionType questionType;

//    @NotBlank
    private String date_create;
//    @NotBlank
    private String status;

    public QuestionDto() {
    }

    public QuestionDto(Integer id, String title, String questions, String answer, QuestionType questionType,
                    String date_create, String status) {
        this.id = id;
        this.title = title;
        this.questions = questions;
        this.answer = answer;
        this.questionType = questionType;
        this.date_create = date_create;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
