package com.utcn.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    @Column(name = "text")
    private String text;
    public Long getTagId() {
        return tagId;
    }
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Tag(Long tagId, String text) {
        this.tagId = tagId;
        this.text = text;
    }
    public Tag(String text) {
        this.text = text;
    }
    public Tag(){}
}
