package com.utcn.demo.controller;

import com.utcn.demo.entity.Question;
import com.utcn.demo.entity.QuestionLike;
import com.utcn.demo.entity.User;
import com.utcn.demo.service.QuestionLikeService;
import com.utcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionlikes")
public class QuestionLikeController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionLikeService questionLikeService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<QuestionLike> retrieveAllQuestionLikes(){
        return this.questionLikeService.retrieveQuestionLikes();
    }
    @GetMapping("/getLikesOfQuestion")
    @ResponseBody
    public List<QuestionLike> retrieveLikesOfQuestion(Question question){
        return this.questionLikeService.getLikesOfQuestion(question);
    }
    @PostMapping("/insertQuestionLike")
    @ResponseBody
    public QuestionLike insertQuestionLike(@RequestBody QuestionLike questionLike){
        User liked = questionLike.getQuestion().getUser();
        int likedScore = liked.getScore();
        if(questionLike.getAmount() < 0){
            liked.setScore(likedScore - 2);
        }else{
            liked.setScore(likedScore + 3);
        }
        this.userService.insertUser(liked);
        questionLike.getQuestion().setUser(liked);
        return this.questionLikeService.insertQuestionLike(questionLike);
    }

    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.questionLikeService.deleteById(id);
    }
}