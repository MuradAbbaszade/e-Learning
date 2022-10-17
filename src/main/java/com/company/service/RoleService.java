package com.company.service;

import com.company.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity findById(Long id) throws Exception;
    RoleEntity findByName(String email) throws Exception;
    List<RoleEntity> findAll();
    RoleEntity save(RoleEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
