package com.utcn.demo.service;

import com.utcn.demo.entity.Answer;
import com.utcn.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    //todo update
}
