package com.ujiuye.service;

import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.ActorAndRegion;

import java.util.List;

public interface IActorService {

    // 查询演员列表
    public List<Actor> findAll();

    // 保存的方法
    public void save(Actor actor);

    // 根据id查询
    public Actor findById(int id);

    // 更新一条记录
    public void update(Actor actor);

    // 删除一条记录
    public void delete(int actorId);
}
