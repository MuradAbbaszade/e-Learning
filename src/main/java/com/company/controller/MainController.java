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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    private final CourseService courseService;

    @GetMapping("courses")
    public String showCoursesPage(){
        return "courses";
    }

    @GetMapping("course")
    public String showCoursePage(){
        return "course";
    }

    @GetMapping("main")
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

    @GetMapping("courses/search")
    public ModelAndView searchCourse(@RequestParam("searchQuery") String q) throws Exception {
        List<CourseEntity> courseEntityList = courseService.findByQuery(q);
        List<CourseDto> courseDtoList = new ArrayList<>();
        for(CourseEntity courseEntity : courseEntityList){
            CourseDto courseDto = new CourseDto();
            courseDto.setId(courseEntity.getId());
            courseDto.setName(courseEntity.getName());
            courseDto.setField(courseEntity.getFieldEntity().getName());
            courseDto.setPrice(courseEntity.getPrice());
            courseDto.setImage(courseEntity.getImage());
            courseDto.setTeacherName(courseEntity.getTeacherUserEntity().getName());
            courseDto.setVideoDtoList(toVideoDtoList(courseEntity.getVideoEntityList()));
            courseDtoList.add(courseDto);
        }
        return new ModelAndView("courses","courseList",courseDtoList);
    }

    @GetMapping("course/search")
    public ModelAndView searchCourse(@RequestParam("id") Long id) throws Exception {
        CourseEntity courseEntity =  courseService.findById(id);
        CourseDto courseDto = new CourseDto();
        courseDto.setName(courseEntity.getName());
        courseDto.setField(courseEntity.getFieldEntity().getName());
        courseDto.setPrice(courseEntity.getPrice());
        courseDto.setImage(courseEntity.getImage());
        courseDto.setTeacherName(courseEntity.getTeacherUserEntity().getName());
        courseDto.setVideoDtoList(toVideoDtoList(courseEntity.getVideoEntityList()));
        return new ModelAndView("course","course",courseDto);
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
