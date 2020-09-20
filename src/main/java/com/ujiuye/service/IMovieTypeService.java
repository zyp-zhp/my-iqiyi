package com.ujiuye.service;

import com.ujiuye.daomain.Movietype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieTypeService {
    List<Movietype> findAll();
}
