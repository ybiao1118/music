package com.cqyb.music.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yanbiao
 * @Date: 2019/1/22 17:22
 * @Description:
 */
public class FileUtil {


    public static Map<String, String> uploadFile(String FileName, MultipartFile file, String filePath) {

        String name = file.getOriginalFilename();
        String suffixName = name.substring(name.lastIndexOf("."));
        String originFileName = FileName + suffixName;
        Map<String, String> map = new HashMap<>();
//        File saveFile = new File(Common.URL + filePath + originFileName);
//        File parentFile = saveFile.getParentFile();
//        if (saveFile.exists()) {
//
//            saveFile.delete();
//        } else {
//            if (!parentFile.exists()) {
//                parentFile.mkdirs();
//            }
//        }

        File desFile = new File(Common.URL + filePath + originFileName);
        if (!desFile.getParentFile().exists()) {
            desFile.mkdirs();
        }
        try {
            map.put("code", "true");
            map.put("msg", filePath + originFileName);
            file.transferTo(desFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            map.put("code", "false");
            map.put("msg", "上传文件失败");

        }

        return map;
    }

}
