package com.company.serviceImpl;

import com.company.entity.TeacherEntity;

import java.util.List;

public interface TeacherServiceImpl {
    TeacherEntity findById(Long id) throws Exception;
    TeacherEntity findByEmail(String email) throws Exception;
    List<TeacherEntity> findAll();
    TeacherEntity save(TeacherEntity studentEntity);
    void deleteById(Long id) throws Exception;
}
