package com.utcn.demo.service;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> retrieveAnswer(){
        return (List<Answer>) this.answerRepository.findAll();
    }
    public Answer insertAnswer(Answer answer){
        return this.answerRepository.save(answer);
    }

    public String deleteById(Long id){
        try{
            this.answerRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete answer with id " + id;
        }
    }

    public List<Answer> getAnswersOfQuestion(Long questionId) {
        List<Answer> allAnswers = (List<Answer>) answerRepository.findAll();

        List<Answer> answersOfQuestion = allAnswers.stream()
                .filter(answer -> answer.getQuestion().getQuestionId().equals(questionId))
                .collect(Collectors.toList());

        return answersOfQuestion;
    }
    //todo update
}
