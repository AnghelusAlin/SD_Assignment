package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "image")
    private String image;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Question(User user, String title, String text, LocalDateTime time, String image) {
        this.user = user;
        this.title = title;
        this.text = text;
        this.time = time;
        this.image = image;
    }
    public Question(User user, String title, String text, String image) {
        this.user = user;
        this.title = title;
        this.text = text;
        LocalDateTime time = LocalDateTime.now();
        this.time = time;
        this.image = image;
    }

    public Question(Long questionId, User user, String title, String text, LocalDateTime time, String image) {
        this.questionId = questionId;
        this.user = user;
        this.title = title;
        this.text = text;
        this.time = time;
        this.image = image;
    }
    public Question(){

    }
}
