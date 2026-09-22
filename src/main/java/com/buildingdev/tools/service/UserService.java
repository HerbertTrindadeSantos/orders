package com.buildingdev.tools.service;

import com.buildingdev.tools.entities.User;
import com.buildingdev.tools.service.exception.UserNotFoundException;
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

        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));

        return user;
    }

    public User insert(User newUser){
        return userRepository.save(newUser);
    }

    public User update(Long id,User updateUser){

        User entity = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));

        return userRepository.save(updateData(entity,updateUser));
    }

    private User updateData(User entity, User updateUser){

        entity.setName(updateUser.getName());
        entity.setEmail(updateUser.getEmail());
        entity.setPhone(updateUser.getPhone());

        return entity;
    }

    public void deleteById(@PathVariable Long id){

        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException(id));

        userRepository.delete(user);
    }

}
