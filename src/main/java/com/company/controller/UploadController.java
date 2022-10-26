package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
@RequestMapping("upload")
public class UploadController {

    @GetMapping
    public String showUploadPage(){
        return "upload";
    }
    @PostMapping
    public ModelAndView uploadVideo(@RequestParam("video") MultipartFile video){
        System.out.println(video);
        return new ModelAndView("upload");
    }
}
