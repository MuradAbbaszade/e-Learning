package com.company.serviceImpl;

import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements com.company.service.UserService {

    private final UserRepository studentRepository;

    @Override
    public UserEntity findById(Long id) throws Exception {
        return studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public UserEntity findByEmail(String email) throws Exception {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public List<UserEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found"));
        studentRepository.deleteById(id);
    }
}
