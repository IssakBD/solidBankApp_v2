package com.example.solidbankapp.controller;

import com.example.solidbankapp.dao.UserEntityRepository;
import com.example.solidbankapp.entity.AuthRequest;
import com.example.solidbankapp.entity.AuthResponse;
import com.example.solidbankapp.entity.RegistrationRequest;
import com.example.solidbankapp.entity.UserEntity;
import com.example.solidbankapp.jwt.JwtProvider;
import com.example.solidbankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public ResponseEntity<String> auth(@RequestBody AuthRequest authRequest, HttpServletResponse httpServletResponse) {
//        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
//        String token = jwtProvider.generateToken(userEntity.getLogin());
//        return new AuthResponse(token);

        if (userEntityRepository.findByLogin(authRequest.getLogin()) == null) return ResponseEntity.
                status(HttpStatus.NOT_FOUND).body("Login was not found");
        UserEntity userEntity = userService.findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());
        if (userEntity != null) {
            String token = jwtProvider.generateToken(userEntity.getLogin());
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            httpServletResponse.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("token: " +
                    new AuthResponse(token).getToken());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check your login and/or password");
        }
    }
}