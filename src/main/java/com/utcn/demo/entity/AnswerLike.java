package com.utcn.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer_like")
public class AnswerLike {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "answer_id")
    private Answer answer;

    //amount is 1 for like, -1 for dislike
    @Column(name = "amount")
    private int amount;

    public AnswerLike() {

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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public AnswerLike(Long likeId, User user, Answer answer, int amount) {
        this.likeId = likeId;
        this.user = user;
        this.answer = answer;
        this.amount = amount;
    }

    public AnswerLike(User user, Answer answer, int amount) {
        this.user = user;
        this.answer = answer;
        this.amount = amount;
    }
}
