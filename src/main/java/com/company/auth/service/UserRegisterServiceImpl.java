package com.company.auth.service;

import com.company.dto.UserDto;
import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserService userService;
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
