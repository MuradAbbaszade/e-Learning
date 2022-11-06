package com.company.controller;

import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
@RequestMapping("upload")
public class UploadController {

    @GetMapping
    public String showUploadPage(){
        return "upload";
    }
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ModelAndView uploadVideo(@RequestParam("video") MultipartFile file) throws IOException {
        System.out.println("asd"+file.getName());
        System.out.println(file.getSize());
        return new ModelAndView("upload");
    }
}
