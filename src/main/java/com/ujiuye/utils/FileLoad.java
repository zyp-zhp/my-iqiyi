package com.ujiuye.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileLoad {
    // 上传文件,上传成功后返回存储的路径
    public static String uploadFile(@RequestParam("file") MultipartFile file,
                                    String uploadDir) {
        if(file != null){
            //1.在服务器上创建一个新的文件
            System.out.println("uploadDir : " + uploadDir);
            // E://movie/images/2010-09-09/dsfjkdsjfkdsl.jpg
            // 1.1创建日期目录
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dir = sdf.format(new Date());

            //1.2 创建目录E://movie/images/2010-09-09
            // 创建文件名
            System.out.println(" dir = " + dir);
            File parentDir = new File(uploadDir, dir);
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }
            // 1.3得到上传文件的扩展名
            // 1.3.1 得到上传的文件的名字: 1.abc.jpg
            String uuid = UUID.randomUUID().toString();
            // 得到文件原来的名字
            String originalFilename = file.getOriginalFilename();
            // 得到扩展名
            int index = originalFilename.lastIndexOf(".");
            String fileExter = originalFilename.substring(index);
            // 新的文件名: uuid + fileExter
            String fileName = uuid + fileExter;
            // 创建新文件
            File newFile = new File(parentDir, fileName);
            try {
                // 把图片的数据写到新文件中
                file.transferTo(newFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return newFile.getAbsolutePath();
        }else{
            return "文件不能为空";
        }
    }
}
