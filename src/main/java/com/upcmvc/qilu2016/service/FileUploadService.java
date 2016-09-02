package com.upcmvc.qilu2016.service;

import com.upcmvc.qilu2016.controller.UpLoadFileController;
import com.upcmvc.qilu2016.dto.JsonMes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 陈子枫 on 2016/9/2.
 */
@Service
public class FileUploadService {

    private static final Logger log = LoggerFactory.getLogger(UpLoadFileController.class);

    public static final String ROOT = "/picture/";

    public String handleFileUpload(MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
            } catch (IOException | RuntimeException e) {
            }
            return new JsonMes(-1,"上传失败");
        } else {
            String url = new String();
            url = "http://localhost:80" + ROOT + file.getOriginalFilename();
            return url;
        }

    }
}
