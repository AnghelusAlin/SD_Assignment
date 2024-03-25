package com.utcn.demo.service;

import com.utcn.demo.entity.Question;
import com.utcn.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> retrieveQuestion(){
        return (List<Question>) this.questionRepository.findAll();
    }
    public Question insertQuestion(Question question){
        return this.questionRepository.save(question);
    }
    public Question retrieveQuestionById(Long id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else{
            return null;
        }
    }
    public String deleteById(Long id){
        try{
            this.questionRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete question with id " + id;
        }
    }
    //todo update
}
