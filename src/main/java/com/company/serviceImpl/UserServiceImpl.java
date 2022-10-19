package com.company.serviceImpl;

import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements com.company.service.UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public UserEntity findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity studentEntity) {
        return userRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
        userRepository.deleteById(id);
    }
}
