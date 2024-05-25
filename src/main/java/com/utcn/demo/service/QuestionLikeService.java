package com.utcn.demo.service;

import com.utcn.demo.entity.Question;
import com.utcn.demo.entity.QuestionLike;
import com.utcn.demo.repository.QuestionLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<QuestionLike> getLikesOfQuestion(Question question){
        List<QuestionLike> likes = (List<QuestionLike>)this.questionLikeRepository.findAll();
        return likes.stream()
                                                .filter(like -> like.getQuestion().equals(question))
                                                .collect(Collectors.toList());
    }
}
