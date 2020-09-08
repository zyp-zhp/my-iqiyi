package com.ujiuye.service;

import com.ujiuye.dao.ActorMapper;
import com.ujiuye.daomain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorServiceImpl implements IActorService {
    @Autowired
    private ActorMapper actorMapper;
    @Override
    //查询所有演员的信息
    public List<Actor> findAllActor(){
        List<Actor> actorList=null;
        actorList=actorMapper.findAllActor();
        return actorList;
    }
    @Override
    //添加演员
    public Actor insertActor(Actor actor){
        return actorMapper.insertActor(actor);
    }
    @Override
    //删除演员信息
    public Integer  deleteActorById(Integer id){
        return  actorMapper.deleteActorById(id);
    }
    @Override
    //编辑演员信息
    public Actor updateActorById(Integer id){
        return actorMapper.updateActorById(id);
    }
}
