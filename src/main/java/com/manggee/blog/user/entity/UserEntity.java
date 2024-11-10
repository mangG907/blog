package com.manggee.blog.user.entity;

import com.manggee.blog.user.dto.UserRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;
    private String birthDate;
    private String shop;
    private String phone;

    public UserEntity(String email, String password, String name, String birthDate, String shop, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.shop = shop;
        this.phone = phone;
    }

    public UserEntity() {}

    public void updateUser(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.birthDate = userRequestDto.getBirthDate();
        this.shop = userRequestDto.getShop();
        this.phone = userRequestDto.getPhone();
    }

}
