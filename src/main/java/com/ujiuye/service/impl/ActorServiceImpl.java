package com.ujiuye.service.impl;

import com.ujiuye.dao.ActorMapper;
import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.ActorAndRegion;
import com.ujiuye.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorServiceImpl implements IActorService {
    @Autowired
    private ActorMapper actorMapper;

    @Override
    public List<Actor> findAll() {
        return actorMapper.findAll();
    }

    @Override
    public void save(Actor actor) {
        /*
        保存演员信息:
            3.1 演员的基本信息:在演员表中插入一条记录
            3.2 在演员与区域中间表中插入记录
         */
        //  3.1 演员的基本信息:在演员表中插入一条记录
        actorMapper.save(actor);
        // 在演员与区域中间表中插入记录
        insertActorAndRegion(actor);

    }

    // 在演员与区域中间表中插入记录
    private void insertActorAndRegion(Actor actor) {
        //  3.2 在演员与区域中间表中插入记录
        // 得到演员的id
        int aid = actor.getId();
        // 得到所有区域ID
        String regionsStr = actor.getRegionsStr();
        // 拆分区域ID
        String[] idArray = regionsStr.split(",");
        // 遍历出每个区域id
        for (String rid : idArray) {
            ActorAndRegion aar = new ActorAndRegion(aid, Integer.parseInt(rid));
            actorMapper.saveActorAndRegion(aar);
        }
    }

    @Override
    public Actor findById(int id) {
        return actorMapper.findById(id);
    }

    @Override
    public void update(Actor actor) {
        /*
        在页面修改完成点击提交,调用更新演员的接口updateActor,保存数据
			3.1 根据演员id更新演员表中的记录
			3.2 更新演员与区域的中间表:
				先根据演员id删除相关的记录
				在删除相关的记录
         */
        // 3.1 根据演员id更新演员表中的记录
        actorMapper.update(actor);

        // 3.2 更新演员与区域的中间表:
        // 先根据演员id删除相关的记录
        actorMapper.deleteActorAndRegion(actor.getId());

        // 在插入相关的记录
        insertActorAndRegion(actor);
    }

    @Override
    public void delete(int actorId) {
        // 2.1根据演员的id从 演员与区域的中间表中删除相关的记录
        actorMapper.deleteActorAndRegion(actorId);
        // 2.2根据演员的id从演员表中删除记录
        actorMapper.delete(actorId);
    }
}
