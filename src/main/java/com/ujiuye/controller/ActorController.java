package com.ujiuye.controller;

import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.Region;
import com.ujiuye.service.IActorService;
import com.ujiuye.service.IRegionService;
import com.ujiuye.utils.FileLoad;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("actor")
public class ActorController {
    @Autowired
    private IActorService actorService;

    @Autowired
    private IRegionService regionService;

    @Value("${upload.dir}")
    private String uploadDir;


    @PostMapping("delete")
    public String delete(int actorId){
        actorService.delete(actorId);
        return "删除成功";
    }

    // 更新演员
    @PostMapping("/update")
    public String update(@RequestParam(value = "file") MultipartFile file,
                         Actor actor){
        // 如果照片不为空,就把图片转成base64的字符串设置给actor的pic属性
        if(file != null){
            try {
                actor.setPhoto(Base64.encodeBase64String(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.上传照片
        // 上传缩略图
        FileLoad.uploadFile(file, uploadDir);

        // 2.更新演员的信息
        actorService.update(actor);

        return "提交成功!!";
    }

    // 编辑演员
    @GetMapping("/editActor")
    public Map<String, Object> editActor(int actorId){
        // 1.获得演员的信息:actor对象
        Actor actor = actorService.findById(actorId);
        // 2.获得区域列表: regionList
        List<Region> regionList = regionService.findAll();
        // 3.定义一个map用来封装演员和区域列表
        Map<String, Object> map = new HashMap<>();
        map.put("actor", actor);
        map.put("regionList", regionList);
        // 返回map
        return map;
    }


    @GetMapping("/findAll")
    public List<Actor> findALL(){
        return actorService.findAll();
    }

    // 查询所有的演员区域: 返回区域列表
    @GetMapping("/findAllRegion")
    public List<Region> findAllRegion(){
        return regionService.findAll();
    }

    // 保存演员
    @PostMapping("/save")
    public String save(@RequestParam(value = "file") MultipartFile file,
                       Actor actor){
        // 如果照片不为空,就把图片转成base64的字符串设置给actor的pic属性
        if(file != null){
            try {
                actor.setPhoto(Base64.encodeBase64String(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.上传照片
        // 上传缩略图
        FileLoad.uploadFile(file, uploadDir);

        // 2.保存演员的信息
        actorService.save(actor);

        return "提交成功!!";
    }

}
