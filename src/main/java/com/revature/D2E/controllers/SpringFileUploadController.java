package com.revature.D2E.controllers;

import com.amazonaws.services.s3.transfer.Upload;
import com.revature.D2E.services.S3Service;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;

/*
@RequestMapping("upload")
@RestController
public class SpringFileUploadController {

    @Autowired
    S3Service s3Service;

    @GetMapping("/index")
    public String hello() {
        return "uploader";
    }


    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

        String fileName = file.getOriginalFilename();
        try {
            file.transferTo( new File("C:\\Users\\pzxli\\Desktop\\Upload" + fileName)); // file path
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }

}*/
