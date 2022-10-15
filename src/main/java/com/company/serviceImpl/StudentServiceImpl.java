package com.company.serviceImpl;

import com.company.entity.StudentEntity;

import java.util.List;

public interface StudentServiceImpl {
    StudentEntity findById(Long id) throws Exception;
    List<StudentEntity> findAll();
    StudentEntity save(StudentEntity studentEntity);
    StudentEntity deleteById(Long id);
}
