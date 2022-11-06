package com.company.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CourseDto {
    private String name;
    private double price;
    private String image;
    private String field;
    private String teacherName;
    private List<VideoDto> videoDtoList;
}
