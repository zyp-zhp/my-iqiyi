package com.ujiuye.controller;

import com.ujiuye.daomain.Actor;
import com.ujiuye.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ActorController {
    @Autowired
    private IActorService actorService;
    //查询所有演员的信息
    @GetMapping("/findAll")
    public List<Actor> findAll(){
        return  actorService.findAllActor();
    }
    @GetMapping("/insertActor")
    //添加演员
    public Actor insertActor(Actor actor){
        return  actorService.insertActor(actor);
    }
    @GetMapping("/deleteActorById")
    //删除演员信息
    public Integer  deleteActorById(Integer id){
        return actorService.deleteActorById(id);
    }
    @GetMapping("/updateActorById")
    //编辑演员信息
    public Actor updateActorById(Integer id){
        return actorService.updateActorById(id);
    }
}
