package com.utcn.demo.controller;

import com.utcn.demo.entity.QuestionTag;
import com.utcn.demo.service.QuestionTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questiontags")
public class QuestionTagController {
    @Autowired
    private QuestionTagService questionTagService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<QuestionTag> retrieveAllQuestionTags(){
        return this.questionTagService.retrieveQuestionTag();
    }
    @PostMapping("/insertQuestionTag")
    @ResponseBody
    public QuestionTag insertQuestionTag(@RequestBody QuestionTag questionTag){
        return this.questionTagService.insertQuestionTag(questionTag);
    }
    @PutMapping("/updateQuestionTag")
    @ResponseBody
    public QuestionTag updateQuestionTag(@RequestBody QuestionTag questionTag){
        return this.questionTagService.insertQuestionTag(questionTag);
    }
    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.questionTagService.deleteById(id);
    }
}
