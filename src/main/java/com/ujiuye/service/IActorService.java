package com.ujiuye.service;

import com.ujiuye.daomain.Actor;

import java.util.List;

public interface IActorService {
    //查询所有演员的信息
    public List<Actor> findAllActor();
    //添加演员
    public Actor insertActor(Actor actor);
    //删除演员信息
    public Integer  deleteActorById(Integer id);
    //编辑演员信息
    public Actor updateActorById(Integer id);
}