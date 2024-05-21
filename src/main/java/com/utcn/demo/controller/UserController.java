package com.utcn.demo.controller;

import com.utcn.demo.entity.User;
import com.utcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getAll")
    @ResponseBody
    public List<User> retrieveAllUsers(){
        return this.userService.retrieveUser();
    }
    @PostMapping("/insertUser")
    @ResponseBody
    public User insertUser(@RequestBody User user){
        return this.userService.insertUser(user);
    }
    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        return this.userService.insertUser(user);
    }
    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam Long id){
        System.out.println(id);
        return this.userService.deleteById(id);
    }
}
