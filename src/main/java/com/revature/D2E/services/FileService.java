package com.revature.D2E.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file);
}
