package com.utcn.demo.service;

import com.utcn.demo.entity.QuestionTag;
import com.utcn.demo.entity.Tag;
import com.utcn.demo.repository.QuestionTagRepository;
import com.utcn.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private QuestionTagRepository questionTagRepository;

    public List<Tag> retrieveTag(){
        return (List<Tag>) this.tagRepository.findAll();
    }
    public List<Tag> retrieveTagOfQuestion(Long id){
        List<Tag> tags = new ArrayList<>();
        List<QuestionTag> questionTags = (List<QuestionTag>) this.questionTagRepository.findAll();
        for(QuestionTag qt : questionTags){
            if(qt.getQuestion().getQuestionId().equals(id)){
                if(!tags.contains(qt.getTagId())){
                    tags.add(qt.getTagId());
                }
            }
        }
        return tags;
    }
    public Tag insertTag(Tag tag){
        return this.tagRepository.save(tag);
    }

    public String deleteById(Long id){
        try{
            this.tagRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete tag with id " + id;
        }
    }
    //todo update
}
