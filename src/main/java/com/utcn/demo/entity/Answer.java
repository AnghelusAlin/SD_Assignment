package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "time")
    private Date time;

    @Column(name = "image")
    private String image;

    //todo getters, setters, constructor
}
