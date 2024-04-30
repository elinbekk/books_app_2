package ru.itis.semester_work3.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.semester_work3.services.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.itis.semester_work3.config.UploadConfig.storagePath;

@Service
@RequiredArgsConstructor
public class FilesServiceImpl implements FileService {
    @Override
    public void saveFile(MultipartFile file) {
        try{
            Files.copy(file.getInputStream(), Paths.get(storagePath,
                    file.getOriginalFilename()));
        }catch (IOException e){
            throw new IllegalArgumentException();
        }
    }
}
