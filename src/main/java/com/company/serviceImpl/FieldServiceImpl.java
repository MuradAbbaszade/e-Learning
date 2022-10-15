package com.company.serviceImpl;

import com.company.entity.FieldEntity;

import java.util.List;

public interface FieldServiceImpl {
    FieldEntity findById(Long id) throws Exception;
    List<FieldEntity> findAll();
    FieldEntity save(FieldEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
