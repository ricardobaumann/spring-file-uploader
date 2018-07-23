package com.github.ricardobaumann.springfileuploader.controller;

import com.github.ricardobaumann.springfileuploader.dto.UploadResult;
import com.github.ricardobaumann.springfileuploader.repo.UploadRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FileUploadController {

    private UploadRepository uploadRepository;

    FileUploadController(UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    @PutMapping(value = "/**", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UploadResult put(@RequestBody String body, HttpServletRequest request) throws IOException {
        return uploadRepository.save(request.getRequestURI(), body);
    }

}
