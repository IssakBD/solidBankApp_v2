package com.example.solidbankapp.service;

import com.example.solidbankapp.dao.UserEntityRepository;
import com.example.solidbankapp.entity.UserEntity;
import com.example.solidbankapp.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(UserEntity userEntity) {
        userEntity.setRole("ROLE_USER");
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
         userEntityRepository.insertUser(userEntity.getLogin(),userEntity.getPassword(),userEntity.getRole());
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = userEntityRepository.findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    public UserEntity getUserByUsername(String login){
         return userEntityRepository.findUserEntityByLogin(login)
                 .orElseThrow(() -> new UserNotFound("user not found"));
    }


}