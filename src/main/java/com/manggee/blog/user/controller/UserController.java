package com.manggee.blog.user.controller;

import com.manggee.blog.user.dto.UserRequest;
import com.manggee.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /* http://localhost:8080/user/login
    * {
    *   "userEmail" : "mang.gee@gmail.com"
    *   "userPassword" : "1234"
    * }
    * */
    /*로그인*/
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest.login loginData){

        userService.login(loginData);


        return null;
    }

}
