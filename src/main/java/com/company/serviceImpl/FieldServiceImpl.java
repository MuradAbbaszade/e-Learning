package com.company.serviceImpl;

import com.company.entity.FieldEntity;
import com.company.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements com.company.service.FieldService {

    private final FieldRepository fieldRepository;

    @Override
    public FieldEntity findById(Long id) throws Exception {
        return fieldRepository.findById(id)
                .orElseThrow(()->new Exception("Field not found"));
    }

    @Override
    public List<FieldEntity> findAll() {
        return fieldRepository.findAll();
    }

    @Override
    public FieldEntity save(FieldEntity studentEntity) {
        return fieldRepository.save(studentEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        fieldRepository.findById(id)
                .orElseThrow(()->new Exception("Field not found"));
        fieldRepository.deleteById(id);
    }
}
