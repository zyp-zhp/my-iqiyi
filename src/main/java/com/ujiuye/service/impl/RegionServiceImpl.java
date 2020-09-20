package com.ujiuye.service.impl;

import com.ujiuye.dao.RegionMapper;
import com.ujiuye.daomain.Region;
import com.ujiuye.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {
    @Autowired
    private RegionMapper regionMapper;
    @Override
    public List<Region> findAll() {
        return regionMapper.findAll();
    }
}
