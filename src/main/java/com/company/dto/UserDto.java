package com.company.dto;

import com.company.annotation.EmailExist;
import com.company.annotation.PasswordMatches;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EmailExist
@PasswordMatches
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String matchingPassword;
    private String role;
}
