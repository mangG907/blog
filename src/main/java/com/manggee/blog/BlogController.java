package com.manggee.blog;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/register")
    public String join() {return "register";}

}
