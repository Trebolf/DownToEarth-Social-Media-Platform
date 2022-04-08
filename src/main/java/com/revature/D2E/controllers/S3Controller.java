package com.revature.D2E.controllers;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.revature.D2E.services.S3Service;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("uploadfile")
public class S3Controller {
//
//    @Autowired
//    private S3Service s3Service;
//
//    @PostMapping
//    public String uploadFile(@RequestParam("file") MultipartFile file){
//        String fileName = file.getOriginalFilename();
//        String message = "";
//        try {
//            s3Service.uploadFile(fileName, file.getInputStream());
//            message = "Your file has been uploaded successfully";
//        } catch (Exception e) {
//            message = "Error uploading file: " + e.getMessage();
//        }
//        return message;
//    }
}

