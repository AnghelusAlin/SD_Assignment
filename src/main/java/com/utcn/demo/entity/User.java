package com.utcn.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "score")
    private int score;
    @Column(name = "moderator")
    private Boolean moderator;
    @Column(name = "banned")
    private Boolean banned;
    public Boolean getBanned(){
        return banned;
    }
    public void setBanned(Boolean banned){
        this.banned = banned;
    }
    public Boolean getModerator(){
        return moderator;
    }
    public void setModerator(Boolean moderator){
        this.moderator = moderator;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public User(String username, String email, String phoneNumber, String password, int score, Boolean moderator, Boolean banned) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.score = score;
        this.moderator = moderator;
        this.banned = banned;
    }
    public User(Long userId, String username, String email, String phoneNumber, String password, int score, Boolean moderator, Boolean banned) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.score = score;
        this.moderator = moderator;
        this.banned = banned;
    }
    public User(){}
}
