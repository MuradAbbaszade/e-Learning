package com.company.validator;

import com.company.annotation.EmailExist;
import com.company.dto.UserDto;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailValidator
        implements ConstraintValidator<EmailExist, Object> {

    private final UserService userService;

    @Override
    public void initialize(EmailExist constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto userDto = (UserDto) obj;
        try {
            UserEntity userEntity = userService.findByEmail(userDto.getEmail());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}