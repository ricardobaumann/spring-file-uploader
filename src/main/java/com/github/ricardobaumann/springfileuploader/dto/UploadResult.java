package com.github.ricardobaumann.springfileuploader.dto;

public class UploadResult {
    private final String path;

    public UploadResult(String path) {

        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
