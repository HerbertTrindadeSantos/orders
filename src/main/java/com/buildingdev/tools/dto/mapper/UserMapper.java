package com.buildingdev.tools.dto.mapper;

import com.buildingdev.tools.dto.UserRequestDTO;
import com.buildingdev.tools.dto.UserResponseDTO;
import com.buildingdev.tools.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO userResquest){
        User user = new User();
        user.setName(userResquest.name());
        user.setEmail(userResquest.email());
        user.setPhone(userResquest.phone());
        user.setPassword(userResquest.password());

        return user;
    }

    public UserResponseDTO toUserResponseDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword()
        );
    }
}
