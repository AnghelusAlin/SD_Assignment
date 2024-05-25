package com.utcn.demo.service;

import com.utcn.demo.entity.QuestionLike;
import com.utcn.demo.repository.QuestionLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionLikeService {
    @Autowired
    QuestionLikeRepository questionLikeRepository;

    public List<QuestionLike> retrieveQuestionLikes(){
        return (List<QuestionLike>) this.questionLikeRepository.findAll();
    }

    public QuestionLike insertQuestionLike(QuestionLike questionLike){
        return this.questionLikeRepository.save(questionLike);
    }

    public String deleteById(Long id){
        try{
            this.questionLikeRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete questionLike with id " + id;
        }
    }

    //todo get all questionLikes of a particular question
}
