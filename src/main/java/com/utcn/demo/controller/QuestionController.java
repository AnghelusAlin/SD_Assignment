package com.utcn.demo.controller;

import com.utcn.demo.entity.Question;
import com.utcn.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<Question> retrieveAllQuestions(){
        return this.questionService.retrieveQuestion();
    }
    @GetMapping("/getQuestionById")
    @ResponseBody
    public Question retrieveQuestionById(@RequestParam Long id){
        return this.questionService.retrieveQuestionById(id);
    }
    @PostMapping("/insertQuestion")
    @ResponseBody
    public Question insertQuestion(@RequestBody Question question){
        return this.questionService.insertQuestion(question);
    }
    @PutMapping("/updateQuestion")
    @ResponseBody
    public Question updateQuestion(@RequestBody Question question){
        return this.questionService.insertQuestion(question);
    }
    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.questionService.deleteById(id);
    }
}