package com.company.serviceImpl;

import com.company.entity.CourseEntity;
import com.company.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements com.company.service.CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseEntity findById(Long id) throws Exception {
        return courseRepository.findById(id)
                .orElseThrow(()->new Exception("Course not found"));
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public CourseEntity save(CourseEntity studentEntity) {
        return courseRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        courseRepository.findById(id)
                .orElseThrow(()->new Exception("Course not found"));
        courseRepository.deleteById(id);
    }
}
