package com.company.controller;

import com.company.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("register")
    public String showRegisterPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "register";
    }
    @GetMapping("login")
    public String showLoginPage(){
        return "login";
    }
}
