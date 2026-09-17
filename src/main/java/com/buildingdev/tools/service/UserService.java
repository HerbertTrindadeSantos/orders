package com.buildingdev.tools.service;

import com.buildingdev.tools.entities.User;
import com.buildingdev.tools.exception.UserNotFoundException;
import com.buildingdev.tools.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){

        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Usuario nao encontrado id: "+id));

        return user;
    }

}
