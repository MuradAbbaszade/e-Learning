package com.company.auth.service;

import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.service.RoleService;
import com.company.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        try {
            userService.findByEmail(email);
            redirectStrategy.sendRedirect(request, response, "/");
        } catch (Exception ex) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(token.getPrincipal().getAttributes().get("given_name").toString());
            userEntity.setSurname(token.getPrincipal().getAttributes().get("family_name").toString());
            userEntity.setEmail(email);
            List<RoleEntity> roleEntityList = new ArrayList<>();
            roleEntityList.add(roleService.findById(new Long(1)));
            userEntity.setRoleEntityList(roleEntityList);
            userService.save(userEntity);
        }
    }
}
