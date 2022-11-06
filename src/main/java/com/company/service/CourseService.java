package com.company.service;

import com.company.entity.CourseEntity;

import java.util.List;

public interface CourseService {
    CourseEntity findById(Long id) throws Exception;
    List<CourseEntity> findAll();
    CourseEntity save(CourseEntity studentEntity);
    void deleteById(Long id) throws Exception;
    List<CourseEntity> findByQuery(String q) throws Exception;
}
