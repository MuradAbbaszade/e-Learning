package com.company.service;

import com.company.entity.VideoEntity;

import java.util.List;

public interface VideoService {
    VideoEntity findById(Long id) throws Exception;
    List<VideoEntity> findAll();
    VideoEntity save(VideoEntity videoEntity);
    void deleteById(Long id) throws Exception;
}
