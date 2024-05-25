package com.utcn.demo.controller;

import com.utcn.demo.entity.AnswerLike;
import com.utcn.demo.service.AnswerLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answerlikes")
public class AnswerLikeController {
    @Autowired
    private AnswerLikeService answerLikeService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<AnswerLike> retrieveAllAnswerLikes(){
        return this.answerLikeService.retrieveAnswerLikes();
    }
    @PostMapping("/insertAnswerLike")
    @ResponseBody
    public AnswerLike insertAnswerLike(@RequestBody AnswerLike answerLike){
        return this.answerLikeService.insertAnswerLike(answerLike);
    }
    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.answerLikeService.deleteById(id);
    }
    //todo get answerLikes of a particular answer
}