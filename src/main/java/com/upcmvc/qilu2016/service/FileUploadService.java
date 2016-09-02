package com.upcmvc.qilu2016.service;

import com.upcmvc.qilu2016.config.Config;
import com.upcmvc.qilu2016.controller.UpLoadFileController;
import com.upcmvc.qilu2016.dto.JsonMes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static final String ROOT = "file";

    @Autowired
    private Config config;

    public String handleFileUpload(MultipartFile file) throws IOException {

        String imgname =  "mvc" + System.currentTimeMillis();

        if (!file.isEmpty()) {
                Files.copy(file.getInputStream(), Paths.get(ROOT, imgname));
                return config.serveraddress + "/file/" + imgname;
        }else {
            return "上传失败";
        }

    }
}
