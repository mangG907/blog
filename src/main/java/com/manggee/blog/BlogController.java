package com.manggee.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/register")
    public String register() {return "register";}
}
