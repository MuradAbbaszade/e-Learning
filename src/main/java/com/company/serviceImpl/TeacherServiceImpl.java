package com.company.serviceImpl;

import com.company.entity.RoleEntity;

import java.util.List;

public interface TeacherServiceImpl {
    RoleEntity findById(Long id) throws Exception;
    RoleEntity findByEmail(String email) throws Exception;
    List<RoleEntity> findAll();
    RoleEntity save(RoleEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
