package com.utcn.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_tag")
public class QuestionTag {
    @Id
    @Column(name = "question_tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "tag_id")
    private Long tagId;

    //todo getters, setters, constructors

}
