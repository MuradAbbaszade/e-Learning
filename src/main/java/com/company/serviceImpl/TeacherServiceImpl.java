package com.company.serviceImpl;

import com.company.entity.TeacherEntity;

import java.util.List;

public interface TeacherServiceImpl {
    TeacherEntity findById(Long id);
    List<TeacherEntity> findAll();
    TeacherEntity save(TeacherEntity studentEntity);
    TeacherEntity deleteById(Long id);
}
