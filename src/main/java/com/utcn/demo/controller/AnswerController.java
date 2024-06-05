package com.utcn.demo.controller;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<Answer> retrieveAllAnswers(){
        return this.answerService.retrieveAnswer();
    }
    @GetMapping("/question/{questionId}")
    @ResponseBody
    public List<Answer> getAnswersOfQuestion(@PathVariable Long questionId) {
        return answerService.getAnswersOfQuestion(questionId);
    }
    @PostMapping("/insertAnswer")
    @ResponseBody
    public Answer insertAnswer(@RequestBody Answer answer){
        return this.answerService.insertAnswer(answer);
    }
    @PutMapping("/updateAnswer")
    @ResponseBody
    public Answer updateAnswer(@RequestBody Answer answer){
        return this.answerService.insertAnswer(answer);
    }
    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.answerService.deleteById(id);
    }
}
