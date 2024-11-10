package com.manggee.blog.dto;

import lombok.Data;

@Data
public class UserRequestDto {

    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String birthDate;
    private String shop;
    private String phone;
}
