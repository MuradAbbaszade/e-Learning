package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping
    public ModelAndView uploadVideo(@RequestParam("video") String file) throws IOException {
        System.out.println(file);
        /*byte[] bytes = read(file);
        writeBytesToFile("video",bytes);*/
        return new ModelAndView("upload");
    }

    private void writeBytesToFile(String fileOutput, byte[] bytes) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileOutput)) {
            fos.write(bytes);
        }
    }
    public byte[] read(File file) throws IOException {
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length()];
        fl.read(arr);
        fl.close();
        return arr;
    }
}
