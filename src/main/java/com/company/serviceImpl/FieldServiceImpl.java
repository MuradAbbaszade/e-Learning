package com.company.serviceImpl;

import com.company.entity.FieldEntity;

import java.util.List;

public interface FieldServiceImpl {
    FieldEntity findById(Long id);
    List<FieldEntity> findAll();
    FieldEntity save(FieldEntity studentEntity);
    FieldEntity deleteById(Long id);
}
