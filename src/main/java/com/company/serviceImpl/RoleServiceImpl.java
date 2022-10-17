package com.company.serviceImpl;

import com.company.entity.RoleEntity;
import com.company.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements com.company.service.RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleEntity findById(Long id) throws Exception {
        return roleRepository.findById(id)
        .orElseThrow(() -> new Exception("Role not found"));
    }

    @Override
    public RoleEntity findByName(String name) throws Exception {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new Exception("Role not found"));
    }

    @Override
    public List<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity save(RoleEntity studentEntity) {
        return roleRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        roleRepository.findById(id)
                .orElseThrow(() -> new Exception("Role not found"));
        roleRepository.deleteById(id);
    }
}
