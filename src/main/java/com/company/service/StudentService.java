package com.company.service;

import com.company.entity.StudentEntity;
import com.company.repository.StudentRepository;
import com.company.serviceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements StudentServiceImpl {

    private final StudentRepository studentRepository;

    @Override
    public StudentEntity findById(Long id) throws Exception {
        return studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public StudentEntity findByEmail(String email) throws Exception {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found"));
        studentRepository.deleteById(id);
    }
}
