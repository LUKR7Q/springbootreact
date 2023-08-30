package com.example.demo.service;

import com.example.demo.entity.TextEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.TextRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String id, String pw) {

        Optional<UserEntity> result = userRepository.findById(id);
        UserEntity userEntity = null;
        if(result.isPresent()) {
            userEntity = result.get();
            if (userEntity.getPw().equals(pw)) {
                return "success";
            }
//            System.out.println(userEntity.getId());
//            System.out.println(userEntity.getPw());
        }

        return "fail";
    }

    public void signup(String id, String pw, String name) {
        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .build();

        userRepository.save(userEntity);
    }
}
