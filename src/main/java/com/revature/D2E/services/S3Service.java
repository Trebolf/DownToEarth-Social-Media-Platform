package com.revature.D2E.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class S3Service {
    private String awsId = "AKIAXQD6GW6GLO57RIBF";
    private String secretKey = "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";
    private String region = "us-east-1";
    private String bucketName = "pl-s3bucket";


    public void uploadFile(File file){
        /*prepare our credentials for the next statement */
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsId, secretKey);

        /*create connection with the s3 client */
        AmazonS3 s3Client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        s3Client.putObject(bucketName, "images/" + file.getName(), file);
    }
}