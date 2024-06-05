package com.utcn.demo.controller;

import com.utcn.demo.entity.Tag;
import com.utcn.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<Tag> retrieveAllTags(){
        return this.tagService.retrieveTag();
    }
    @GetMapping("/getTagsOfQuestion/{id}")
    public List<Tag> retrieveTagsOfQuestion(@PathVariable Long id){
        return this.tagService.retrieveTagOfQuestion(id);
    }
    @PostMapping("/insertTag")
    @ResponseBody
    public Tag insertTag(@RequestBody Tag tag){
        return this.tagService.insertTag(tag);
    }

    @PutMapping("/updateTag")
    @ResponseBody
    public Tag updateTag(@RequestBody Tag tag){
        return this.tagService.insertTag(tag);
    }
    @DeleteMapping("deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        return this.tagService.deleteById(id);
    }
}
