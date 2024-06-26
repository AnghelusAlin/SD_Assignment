package com.utcn.demo.service;

import com.utcn.demo.entity.User;
import com.utcn.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private String hash(String password){
        return password;
    }
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserRepository userRepository;

    public List<User> retrieveUser(){
        return (List<User>) this.userRepository.findAll();
    }
    public User insertUser(User user){
        String password = this.hash(user.getPassword());
        user.setPassword(password);
        return this.userRepository.save(user);
    }
    public User banUser(User user){
        user.setBanned(true);
        this.emailSenderService.sendBannedEmail(user);
        return this.userRepository.save(user);
    }
    public User unbanUser(User user){
        user.setBanned(false);
        this.emailSenderService.sendBannedEmail(user);
        return this.userRepository.save(user);
    }

    public User retrieveUserById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }
    public String deleteById(Long id){
        try{
            this.userRepository.deleteById(id);
            return "Delete successful";
        }catch(Exception e){
            return "Failed to delete user with id " + id;
        }
    }
    //todo update

}

