package com.company.service;

import com.company.entity.VideoEntity;
import com.company.repository.VideoRepository;
import com.company.serviceImpl.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoService implements VideoServiceImpl {

    private final VideoRepository videoRepository;

    @Override
    public VideoEntity findById(Long id) throws Exception {
        return videoRepository.findById(id)
                .orElseThrow(()->new Exception("Video not found"));
    }

    @Override
    public List<VideoEntity> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public VideoEntity save(VideoEntity videoEntity) {
        return videoRepository.save(videoEntity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        videoRepository.findById(id)
                .orElseThrow(()->new Exception("Video not found"));
        videoRepository.deleteById(id);
    }
}
