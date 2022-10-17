package com.company.controller;

import com.company.auth.service.UserRegisterService;
import com.company.dto.UserDto;
import com.company.entity.UserEntity;
import com.company.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserRegisterService userRegisterService;
    private final RoleService roleService;

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

    @PostMapping("register")
    public ModelAndView registerUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                Object obj = bindingResult.getAllErrors().get(0);
                ObjectError objectError = null;
                if (obj instanceof ObjectError) {
                    objectError = (ObjectError) obj;
                }
                String message = messageSource().getMessage(objectError, null);
                throw new Exception(message);
            }
        } catch (Exception ex) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        UserEntity userEntity = userRegisterService.registerNewUserAccount(null,userDto);
        return new ModelAndView("main","user",userEntity);
    }

    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
