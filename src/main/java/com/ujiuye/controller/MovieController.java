package com.ujiuye.controller;

import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.Movie;
import com.ujiuye.daomain.Movietype;
import com.ujiuye.daomain.Recommend;
import com.ujiuye.service.IMovieService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private IMovieService movieService;
    @GetMapping("/findAll")
    //1) 电影列表查询接口
    public List<Movie>findAllMovie(){
        return movieService.findAllMovie();
    }
    @Value("${upload.dir}")
    private String uploadDir;
    @PostMapping("/insertMovie")
    //2) 新增电影接口
    public String insertMovie(@RequestParam(value = "file", required = false) MultipartFile pic, Movie movie){
        if(pic != null){
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
            String originalFilename = pic.getOriginalFilename();
            // 得到扩展名
            int index = originalFilename.lastIndexOf(".");
            String fileExter = originalFilename.substring(index);
            // 新的文件名: uuid + fileExter
            String fileName = uuid + fileExter;
            // 创建新文件
            File newFile = new File(parentDir, fileName);

            // 2.把pic文件中数据写到 新的文件中
            try {
                // 把图片转成base64编码的字符串
                String base64Str = Base64.encodeBase64String(pic.getBytes());
                // 把base64编码的字符串保存到对象中, 会插入到表的pic字段中
                movie.setPhoto(base64Str);

                // 把图片的数据写到新文件中
                pic.transferTo(newFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("controller movie = " + movie);
         movieService.insertMovie(movie);
        return "保存成功";
    }
    @GetMapping("/updateMovieById")
    //3) 修改电影接口
    public Integer updateMovieById(Movie movie){
        return movieService.updateMovieById(movie);
    }
    @GetMapping("/deleteMovieById")
    //4) 删除电影接口
    public Integer deleteMovieById(Integer id){
        return movieService.deleteMovieById(id);
    }
    @GetMapping("/findMoviedirectionById")
    //    1) 电影详情接口
    public Movie findMoviedirectionById(Integer id){
        return movieService.findMoviedirectionById(id);
    }
    @GetMapping("/findMovieTypeById")
    //2) 电影类别接口
    public List<Movietype> findMovieTypeById(Integer id){
        return movieService.findMovieTypeById(id);
    }
    @GetMapping("/findRecommendById")
    //    1) 电影推荐列表接口
    public List<Recommend> findRecommendById(Integer id){
        return movieService.findRecommendById(id);
    }
    @GetMapping("/findMovieById")
    //2) 电影播放接口
    public Integer findMovieById(Integer id){
        return movieService.findMovieById(id);
    }
    @GetMapping("/findMovieActorById")
    //    1) 电影演员查询列表接口
    public List<Actor> findMovieActorById(Integer id){
        return movieService.findMovieActorById(id);
    }
    @GetMapping("/insertMovieActorById")
    //2) 添加电影演员接口
    public Actor insertMovieActorById(Movie movie){
        return movieService.insertMovieActorById(movie);
    }
    @GetMapping("/updateMovieActorById")
    //3) 编辑电影演员接口
    public Integer updateMovieActorById(Integer id){
        return movieService.updateMovieActorById(id);
    }
    @GetMapping("/deleteMovieActorById")
    //4) 删除电影演员接口
    public Integer deleteMovieActorById(Integer id){
        return  movieService.deleteMovieActorById(id);
    }
}
