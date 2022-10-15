package com.company.serviceImpl;

import com.company.entity.StudentEntity;

import java.util.List;

public interface StudentServiceImpl {
    StudentEntity findById(Long id) throws Exception;
    StudentEntity findByEmail(String email) throws Exception;
    List<StudentEntity> findAll();
    StudentEntity save(StudentEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
