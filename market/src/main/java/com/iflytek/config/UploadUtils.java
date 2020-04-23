package com.iflytek.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class UploadUtils {
    public static String upload(MultipartFile file, String path, String fileName,int num) throws Exception {
        File dest=null;
        // 生成新的文件名
        if(num==1) {        //上传文件功能
            String realPath = path + "/" + UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
             dest = new File(realPath);
            // 判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            // 保存文件
            file.transferTo(dest);
        }else{                //删除文件功能
             dest = new File(path);
            // 判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            // 删除文件
            dest.delete();
        }

        return dest.getName();
    }
}