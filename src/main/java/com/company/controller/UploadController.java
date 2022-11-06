package com.company.controller;

import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ModelAndView uploadVideo(@RequestParam("video") MultipartFile multipartFile,
                                    @RequestParam("name") String name) throws IOException {
        System.out.println("asd"+name);
        System.out.println(multipartFile.getSize());
        File file = new File(name+".mp4");
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }
        return new ModelAndView("upload");
    }
}
