package com.utcn.demo.service;

import com.utcn.demo.entity.QuestionTag;
import com.utcn.demo.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTagService {
    @Autowired
    private QuestionTagRepository questionTagRepository;

    public List<QuestionTag> retrieveQuestionTag(){
        return (List<QuestionTag>) this.questionTagRepository.findAll();
    }

    public QuestionTag insertQuestionTag(QuestionTag tag){
        return this.questionTagRepository.save(tag);
    }

    public String deleteById(Long id){
        try{
            this.questionTagRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete question-tag with id " + id;
        }
    }
    //todo update
}
