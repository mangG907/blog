package com.manggee.blog;

import com.manggee.blog.dto.UserRequestDto;
import com.manggee.blog.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/register")
    public String join() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto); // DB에 사용자 저장
        return "redirect:/"; // 회원가입 완료 후 메인 페이지로 이동
    }
}
