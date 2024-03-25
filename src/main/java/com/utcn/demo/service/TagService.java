package com.utcn.demo.service;

import com.utcn.demo.entity.Tag;
import com.utcn.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> retrieveTag(){
        return (List<Tag>) this.tagRepository.findAll();
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
