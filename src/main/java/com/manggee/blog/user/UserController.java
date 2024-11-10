package com.manggee.blog.user;

import com.manggee.blog.user.dto.UserRequestDto;
import com.manggee.blog.user.dto.UserResponseDto;
import com.manggee.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user/register")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("UserRequestDto", new UserRequestDto());
        return "register";
    }

    @PostMapping
    public String registerUser(UserRequestDto userRequestDto, BindingResult bindingResult, Model model) {
        // 비밀번호 일치 여부 검증
        if (!userRequestDto.getPassword().equals(userRequestDto.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "비밀번호가 일치하지 않습니다.");
        }

        if (bindingResult.hasErrors()) {
            return "register";  // 오류가 있으면 다시 등록 페이지로 리다이렉트
        }


        try {
            /* 사용자 생성 */
            UserResponseDto.SaveUser savedUser = userService.createUser(userRequestDto);
            model.addAttribute("user", savedUser);
            return "redirect:/login";  // 회원가입 성공 시 로그인 페이지
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";  // 오류메시지 + 회원가입 페이지
        }
    }




}
