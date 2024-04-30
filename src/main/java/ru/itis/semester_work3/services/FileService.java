package ru.itis.semester_work3.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void saveFile(MultipartFile file);
}
