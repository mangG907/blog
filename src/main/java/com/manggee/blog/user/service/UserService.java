package com.manggee.blog.user.service;

import com.manggee.blog.user.dto.UserRequest;
import com.manggee.blog.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<?> login(UserRequest.login loginData){
        String email = loginData.getUserEmail();
        String password = loginData.getUserPassword();

        /* 이메일이 존재하는 검사 */
        System.out.println(
                userRepository.findByUserEmail(email).get()
        );

        return null;
    }

}
