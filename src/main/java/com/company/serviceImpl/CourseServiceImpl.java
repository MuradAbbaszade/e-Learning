package com.company.serviceImpl;

import com.company.entity.CourseEntity;

import java.util.List;

public interface CourseServiceImpl {
    CourseEntity findById(Long id);
    List<CourseEntity> findAll();
    CourseEntity save(CourseEntity studentEntity);
    CourseEntity deleteById(Long id);
}
