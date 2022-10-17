package com.company.auth.service;

import com.company.dto.UserDto;
import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserServiceImpl userService;
    @Override
    public UserEntity registerNewUserAccount(List<RoleEntity> roleEntityList,UserDto userDto) {
        return userService.save(
                UserEntity.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .roleEntityList(roleEntityList)
                .build()
        );
    }
}
