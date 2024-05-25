package com.utcn.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_like")
public class QuestionLike {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question;

    //amount is 1 for like, -1 for dislike
    @Column(name = "amount")
    private int amount;

    public QuestionLike() {

    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public QuestionLike(Long likeId, User user, Question question, int amount) {
        this.likeId = likeId;
        this.user = user;
        this.question = question;
        this.amount = amount;
    }

    public QuestionLike(User user, Question question, int amount) {
        this.user = user;
        this.question = question;
        this.amount = amount;
    }
}
