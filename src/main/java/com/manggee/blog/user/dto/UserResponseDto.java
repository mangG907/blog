package com.manggee.blog.user.dto;

import com.manggee.blog.user.entity.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;

public class UserResponseDto {
    @Data
    public static class SaveUser {
        private String email;
        private String password;
        private String name;
        private String birthDate;
        private String shop;
        private String phone;
        private LocalDateTime createdAt;

        public SaveUser(String email, String password, String name, String birthDate, String shop, String phone) {
            this.email = email;
            this.password = password;
            this.name = name;
            this.birthDate = birthDate;
            this.shop = shop;
            this.phone = phone;
            this.createdAt = LocalDateTime.now();
        }

        public SaveUser(UserEntity newUser) {
        }
    }
}
