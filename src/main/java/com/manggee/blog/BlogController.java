package com.manggee.blog;

import com.manggee.blog.user.dto.UserRequestDto;
import com.manggee.blog.user.service.UserService;
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

}
