package com.company.serviceImpl;

import com.company.entity.UserEntity;

import java.util.List;

public interface StudentServiceImpl {
    UserEntity findById(Long id) throws Exception;
    UserEntity findByEmail(String email) throws Exception;
    List<UserEntity> findAll();
    UserEntity save(UserEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
