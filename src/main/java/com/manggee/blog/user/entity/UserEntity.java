package com.manggee.blog.user.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String userPassword;
    private String userEmail;
    private String userName;
    private LocalDate userBirthday;

    @Enumerated(EnumType.STRING)
    private Gender userGender;
}
