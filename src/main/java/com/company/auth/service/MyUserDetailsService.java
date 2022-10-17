package com.company.auth.service;

import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.serviceImpl.RoleServiceImpl;
import com.company.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    private final RoleServiceImpl roleService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            UserEntity userEntity = userService.findByEmail(email);
            User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);

            builder.disabled(false);
            builder.password(userEntity.getPassword());
            List<GrantedAuthority> authorityList = new ArrayList<>();
            for(RoleEntity role : userEntity.getRoleEntityList()){
                authorityList.add(new SimpleGrantedAuthority(role.getName()));
            }
            builder.authorities(authorityList);
            return builder.build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("Email or password incorrect.");
        }

    }
}
