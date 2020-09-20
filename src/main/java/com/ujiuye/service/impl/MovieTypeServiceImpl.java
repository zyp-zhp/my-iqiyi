package com.ujiuye.service.impl;

import com.ujiuye.dao.MovietypeMapper;
import com.ujiuye.daomain.Movietype;
import com.ujiuye.service.IMovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTypeServiceImpl implements IMovieTypeService{
    @Autowired
    private MovietypeMapper movietypeMapper;

    @Override
    public List<Movietype> findAll() {
        return movietypeMapper.findAll();
    }
}
