package com.utcn.demo.controller;

import com.utcn.demo.entity.QuestionLike;
import com.utcn.demo.service.QuestionLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionlikes")
public class QuestionLikeController {
    @Autowired
    private QuestionLikeService questionLikeService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<QuestionLike> retrieveAllQuestionLikes(){
        return this.questionLikeService.retrieveQuestionLikes();
    }
    @PostMapping("/insertQuestionLike")
    @ResponseBody
    public QuestionLike insertQuestionLike(@RequestBody QuestionLike questionLike){
        return this.questionLikeService.insertQuestionLike(questionLike);
    }

    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.questionLikeService.deleteById(id);
    }
}