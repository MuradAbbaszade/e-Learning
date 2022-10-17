package com.company.dto;

import com.company.annotation.EmailExist;
import com.company.annotation.PasswordMatches;
import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EmailExist
@PasswordMatches
public class UserDto {

    @Autowired
    RoleService roleService;
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String matchingPassword;
}
