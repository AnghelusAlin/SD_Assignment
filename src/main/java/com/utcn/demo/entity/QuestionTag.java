package com.utcn.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_tag")
public class QuestionTag {
    @Id
    @Column(name = "question_tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne()
    @JoinColumn(name = "tag_id")
    private Tag tagId;

    public Long getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(Long questionTagId) {
        this.questionTagId = questionTagId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Tag getTagId() {
        return tagId;
    }

    public void setTagId(Tag tagId) {
        this.tagId = tagId;
    }

    public QuestionTag(Long questionTagId, Question question, Tag tagId) {
        this.questionTagId = questionTagId;
        this.question = question;
        this.tagId = tagId;
    }

    public QuestionTag(Question question, Tag tagId) {
        this.question = question;
        this.tagId = tagId;
    }

    public QuestionTag(){

    }
}
