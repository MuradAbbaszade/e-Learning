package com.company.service;

import com.company.entity.FieldEntity;

import java.util.List;

public interface FieldService {
    FieldEntity findById(Long id) throws Exception;
    List<FieldEntity> findAll();
    FieldEntity save(FieldEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
