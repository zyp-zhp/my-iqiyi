package com.ujiuye.controller;

import com.ujiuye.daomain.RecommendType;
import com.ujiuye.service.IRecommendTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("recommendType")
public class RecommendTypeController {
    @Autowired
    private IRecommendTypeService recommendTypeService;

    @GetMapping("findAll")
    public List<RecommendType> findAll(){
        return recommendTypeService.findAll();
    }

    @GetMapping("nowRecommend")
    public String nowRecommend(String ids){
        // "1,2"
        recommendTypeService.nowRecommend(ids);
        return "提交成功";
    }
}
