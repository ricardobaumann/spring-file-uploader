package com.github.ricardobaumann.springfileuploader.repo;

import com.github.ricardobaumann.springfileuploader.config.UploadProperties;
import com.github.ricardobaumann.springfileuploader.dto.UploadResult;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
public class UploadRepository {

    private final UploadProperties uploadProperties;

    UploadRepository(UploadProperties uploadProperties) {
        this.uploadProperties = uploadProperties;
    }

    public UploadResult save(String path, String body) throws IOException {
        File filePath = new File(uploadProperties.getBasePath() + "/" + path);
        if (!filePath.exists()) {
            filePath.getParentFile().mkdirs();
        }
        Files.write(Paths.get(filePath.getAbsolutePath()), body.getBytes());
        return new UploadResult(filePath.getAbsolutePath());
    }
}
