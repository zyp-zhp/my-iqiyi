package com.ujiuye.controller;

import com.ujiuye.daomain.Actor;
import com.ujiuye.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ActorController {
    @Autowired
    private IActorService actorService;
    @GetMapping("/findAll")
    public List<Actor> findAll(){
        return  actorService.findAllActor();
    }
}
