package com.company.auth.service;

import com.company.dto.UserDto;
import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserServiceImpl userService;
    @Override
    public UserEntity registerNewUserAccount(List<RoleEntity> roleEntityList,UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(passwordEncoder().encode(userDto.getPassword()));
        userEntity.setRoleEntityList(roleEntityList);
        return userService.save(userEntity);
    }
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
