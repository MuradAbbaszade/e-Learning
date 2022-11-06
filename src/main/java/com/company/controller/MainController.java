package com.company.controller;

import com.company.dto.CourseDto;
import com.company.dto.VideoDto;
import com.company.entity.CourseEntity;
import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
import com.company.entity.VideoEntity;
import com.company.service.CourseService;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("main")
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    private final CourseService courseService;

    @GetMapping
    public ModelAndView showMainPage(WebRequest request) throws Exception {
        UserEntity user = userService.findByEmail(request.getRemoteUser());
        String userRole="";
        for(RoleEntity role : user.getRoleEntityList()){
            if(role.getName().equals("STUDENT")) userRole="STUDENT";
            else if(role.getName().equals("TEACHER")) userRole="TEACHER";
        }
        ModelAndView mv = new ModelAndView("main","userRole",userRole);
        return mv;
    }

    @GetMapping("courses/search/q={q}")
    public ResponseEntity<List<CourseDto>> searchCourse(@PathVariable String q) throws Exception {
        List<CourseEntity> courseEntityList = courseService.findByQuery(q);
        List<CourseDto> courseDtoList = new ArrayList<>();
        for(CourseEntity courseEntity : courseEntityList){
            CourseDto courseDto = new CourseDto();
            courseDto.setName(courseEntity.getName());
            courseDto.setField(courseEntity.getFieldEntity().getName());
            courseDto.setPrice(courseEntity.getPrice());
            courseDto.setImage(courseEntity.getImage());
            courseDto.setTeacherName(courseEntity.getTeacherUserEntity().getName());
            courseDto.setVideoDtoList(toVideoDtoList(courseEntity.getVideoEntityList()));
            courseDtoList.add(courseDto);
        }
        return ResponseEntity.ok(courseDtoList);
    }
    public List<VideoDto> toVideoDtoList(List<VideoEntity> videoEntityList){
        List<VideoDto> videoDtoList = new ArrayList<>();
        for(VideoEntity videoEntity : videoEntityList){
            VideoDto videoDto = new VideoDto();
            videoDto.setLink(videoEntity.getLink());
            videoDto.setName(videoEntity.getName());
            videoDtoList.add(videoDto);
        }
        return videoDtoList;
    }
}
