package com.buildingdev.tools.service;

import com.buildingdev.tools.dto.UserRequestDTO;
import com.buildingdev.tools.dto.UserResponseDTO;
import com.buildingdev.tools.dto.mapper.UserMapper;
import com.buildingdev.tools.entities.User;
import com.buildingdev.tools.service.exception.UserDatabaseException;
import com.buildingdev.tools.service.exception.UserNotFoundException;
import com.buildingdev.tools.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> findAll(){
        return userRepository.findAll().stream().map(userMapper::toUserResponseDTO).toList();
    }

    public UserResponseDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO insert(UserRequestDTO user){
        User newUser = userMapper.toEntity(user);
        userRepository.save(newUser);

        return userMapper.toUserResponseDTO(newUser);
    }

    public UserResponseDTO update(Long id,UserRequestDTO user){

        User updateUser = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
        userRepository.save((updateData(updateUser,user)));

        UserResponseDTO userResponseDTO = userMapper.toUserResponseDTO(updateUser);

        return userResponseDTO;
    }

    private User updateData(User entity, UserRequestDTO updateUser){

        entity.setName(updateUser.name());
        entity.setEmail(updateUser.email());
        entity.setPhone(updateUser.phone());

        return entity;
    }

    public void deleteById(@PathVariable Long id){

        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException(id));
        try{
            userRepository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(id);
        }
    }

}
