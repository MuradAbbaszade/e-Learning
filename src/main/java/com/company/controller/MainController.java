package com.company.controller;

import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main")
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    @GetMapping
    public ModelAndView showMainPage(WebRequest request) throws Exception {
        UserEntity user = userService.findByEmail(request.getRemoteUser());
        String userRole="";
        for(RoleEntity role : user.getRoleEntityList()){
            if(role.getName().equals("STUDENT")) userRole="STUDENT";
            else if(role.getName().equals("TEACHER")) userRole="TEACHER";
        }
        ModelAndView mv = new ModelAndView("main","userRole",userRole);
        return mv;
    }
}
