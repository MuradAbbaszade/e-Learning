package com.company.auth.service;

import com.company.dto.UserDto;
import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;

import java.util.List;

public interface UserRegisterService {
    UserEntity registerNewUserAccount(List<RoleEntity> roleEntityList,UserDto userDto);
}
