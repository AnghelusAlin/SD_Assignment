package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "question_id")
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

    //todo getters, setters, constructors
    //maybe a local List for tags


}
