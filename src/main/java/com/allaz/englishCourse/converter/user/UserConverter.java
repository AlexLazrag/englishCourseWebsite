package com.allaz.englishCourse.converter.user;

import com.allaz.englishCourse.dto.user.UserRequest;
import com.allaz.englishCourse.dto.user.UserResponse;
import com.allaz.englishCourse.entity.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserConverter {

    public User createUser (UserRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .userRole(request.getUserRole())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public UserResponse toResponse(User user){
        return new UserResponse(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
    }
}
