package com.buildingdev.tools.service;

import com.buildingdev.tools.entities.User;
import com.buildingdev.tools.exception.UserNotFoundException;
import com.buildingdev.tools.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public User insert(User updateUser){

        User newUser = new User();

        newUser.setName(updateUser.getName());
        newUser.setEmail(updateUser.getEmail());
        newUser.setPhone(updateUser.getPhone());
        newUser.setPassword(updateUser.getPassword());

        return userRepository.save(newUser);
    }

    public void deleteById(@PathVariable Long id){

        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("Usuario nao encontrado id: "+id));

        userRepository.delete(user);
    }

}
