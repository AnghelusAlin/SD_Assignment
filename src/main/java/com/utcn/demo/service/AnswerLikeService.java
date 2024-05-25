package com.utcn.demo.service;

import com.utcn.demo.entity.AnswerLike;
import com.utcn.demo.repository.AnswerLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerLikeService {
    @Autowired
    AnswerLikeRepository answerLikeRepository;

    public List<AnswerLike> retrieveAnswerLikes(){
        return (List<AnswerLike>) this.answerLikeRepository.findAll();
    }

    public AnswerLike insertAnswerLike (AnswerLike answerLike){
        return this.answerLikeRepository.save(answerLike);
    }

    public String deleteById(Long id){
        try{
            this.answerLikeRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete answerLike with id " + id;
        }
    }
    //todo get all answerLikes of a particular answer
}
