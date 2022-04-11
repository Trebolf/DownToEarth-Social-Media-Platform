package com.revature.D2E.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service implements FileService{

    @Autowired
    private AmazonS3Client s3Client;

    @Override
    public String uploadFile(MultipartFile file) {

        //variable to define file type (jpg, png, gif, etc.)
        String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        String key = UUID.randomUUID().toString() + "." + filenameExtension;

        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setContentLength(file.getSize());
        metaData.setContentType(file.getContentType());


        //your bucket name is the first parameter inside s3client methods.
        try {
            s3Client.putObject("fvw-bucket-s3-1", key, file.getInputStream(), metaData);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occurred while uploading the file.");
        }

        s3Client.setObjectAcl("fvw-bucket-s3-1", key, CannedAccessControlList.PublicRead);

        return s3Client.getResourceUrl("fvw-bucket-s3-1", key);
    }
}
