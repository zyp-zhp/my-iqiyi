package com.ujiuye.dao;

import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.ActorAndRegion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {
    // 查询演员列表
    public List<Actor> findAll();

    // 保存的方法
    public void save(Actor actor);

    // 根据id查询
    public Actor findById(int id);

    // 保存的方法
    public void update(Actor actor);

    // 保存演员与区域关联记录的方法
    public void saveActorAndRegion(ActorAndRegion aar);

    // 删除演员与区域关联记录的方法
    public void deleteActorAndRegion(int id);

    // 删除演员
    public void delete(int actorId);

}
