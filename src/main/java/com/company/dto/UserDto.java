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
    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 2, max = 15, message = "Name size must be between 2 and 15")
    private String name;
    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 2, max = 40, message = "Surname size must be between 2 and 40")
    private String surname;
    private String email;
    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 2, max = 30, message = "Password size must be between 2 and 30")
    private String password;
    @NotEmpty(message = "Please fill the all fields")
    private String matchingPassword;
}
