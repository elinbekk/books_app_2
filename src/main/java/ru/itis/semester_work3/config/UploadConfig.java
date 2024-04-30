package ru.itis.semester_work3.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class UploadConfig {
    public final static String storagePath = "/Users/mildredm/univer/books_app/src/main/resources/photo/";
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("2MB"));
        factory.setMaxRequestSize(DataSize.parse("2MB"));
        return factory.createMultipartConfig();
    }
}
