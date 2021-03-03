package com.ricgra.app.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileUtils {

    public static InputStream getFileAsInputStream(String filename) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:" + filename);
        return new FileInputStream(file);
    }

}
