package com.utcn.demo.controller;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.entity.AnswerLike;
import com.utcn.demo.entity.User;
import com.utcn.demo.service.AnswerLikeService;
import com.utcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answerlikes")
public class AnswerLikeController {
    @Autowired
    private AnswerLikeService answerLikeService;
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<AnswerLike> retrieveAllAnswerLikes(){
        return this.answerLikeService.retrieveAnswerLikes();
    }
    @GetMapping("/getLikesOfAnswer")
    @ResponseBody
    public List<AnswerLike> retrieveLikesOfAnswer(@RequestBody Answer answer){
        return this.answerLikeService.getLikesOfAnswer(answer);
    }
    @PostMapping("/insertAnswerLike")
    @ResponseBody
    public AnswerLike insertAnswerLike(@RequestBody AnswerLike answerLike){
        User liker = answerLike.getUser();
        User liked = answerLike.getAnswer().getUser();
        int likerScore = liker.getScore();
        int likedScore = liked.getScore();
        if(answerLike.getAmount() < 0){
            liker.setScore(likerScore - 2);
            liked.setScore(likedScore - 3);
            this.userService.insertUser(liker);
        }else{
            liked.setScore(likedScore + 5);
        }
        this.userService.insertUser(liked);
        answerLike.setUser(liker);
        answerLike.getAnswer().setUser(liked);
        return this.answerLikeService.insertAnswerLike(answerLike);
    }
    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.answerLikeService.deleteById(id);
        //should update the user's score if they delete a downvote
    }
}