package com.manggee.blog.user.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class UserRequest {

    @Data
    public static class login{
        private String userEmail;
        private String userPassword;
    }
}
