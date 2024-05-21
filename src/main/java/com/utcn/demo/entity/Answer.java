package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "time")
    private LocalDateTime time;
    @Column(name = "image")
    private String image;

    public Long getAnswerId() {
        return answerId;
    }
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Answer(){}
    public Answer(Question question, Long user_id, String title, String text, LocalDateTime time, String image) {
        this.question = question;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        this.time = time;
        this.image = image;
    }
    public Answer(Question question, Long user_id, String title, String text, String image) {
        this.question = question;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        this.time = LocalDateTime.now();
        this.image = image;
    }
    public Answer(Long answerId, Question question, Long user_id, String title, String text, LocalDateTime time, String image) {
        this.answerId = answerId;
        this.question = question;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        this.time = time;
        this.image = image;
    }
}
