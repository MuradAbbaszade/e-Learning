package com.company.service;

import com.company.entity.RoleEntity;
import com.company.repository.TeacherRepository;
import com.company.serviceImpl.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService implements TeacherServiceImpl {

    private final TeacherRepository teacherRepository;

    @Override
    public RoleEntity findById(Long id) throws Exception {
        return teacherRepository.findById(id)
        .orElseThrow(() -> new Exception("Teacher not found"));
    }

    @Override
    public RoleEntity findByEmail(String email) throws Exception {
        return teacherRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Teacher not found"));
    }

    @Override
    public List<RoleEntity> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public RoleEntity save(RoleEntity studentEntity) {
        return teacherRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        teacherRepository.findById(id)
                .orElseThrow(() -> new Exception("Teacher not found"));
        teacherRepository.deleteById(id);
    }
}
