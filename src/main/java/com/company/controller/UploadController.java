package com.company.controller;

import com.company.dto.CourseDto;
import com.company.entity.CourseEntity;
import com.company.entity.UserEntity;
import com.company.entity.VideoEntity;
import com.company.service.CourseService;
import com.company.service.UserService;
import com.company.service.VideoService;
import com.company.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("upload")
@RequiredArgsConstructor
public class UploadController {

    private final UserService userService;
    private final VideoService videoService;
    private final CourseService courseService;

    @GetMapping
    public ModelAndView showUploadPage(WebRequest request) throws Exception {
        UserEntity user = userService.findByEmail(request.getRemoteUser());
        List<CourseEntity> courseEntityList = user.getCreatedCourseEntityList();
        List<CourseDto> courseDtoList =  new ArrayList<>();
        for(CourseEntity courseEntity : courseEntityList){
            CourseDto courseDto = new CourseDto();
            courseDto.setId(courseEntity.getId());
            courseDto.setName(courseEntity.getName());
            courseDtoList.add(courseDto);
        }
        return new ModelAndView("upload","courses",courseDtoList);
    }
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ModelAndView uploadVideo(@RequestParam("video") MultipartFile multipartFile,
                                    @RequestParam("name") String name,
                                    @RequestParam("id")Long id) throws Exception {
        File file = new File("src/main/resources/video/"+name+".mp4");
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
            VideoEntity videoEntity = new VideoEntity();
            videoEntity.setCourseEntity(courseService.findById(id));
            videoEntity.setName(name);
            videoEntity.setLink("src/main/resources/video/"+name+".mp4");
            videoService.save(videoEntity);
        }
        return new ModelAndView("upload");
    }
}
