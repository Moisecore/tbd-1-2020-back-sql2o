package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Emervolu;
import com.example.tbd.repository.EmervoluRepository;
import com.example.tbd.service.EmervoluService;

@Service
public class EmervoluServiceImpl extends GenericServiceImpl<Emervolu, Long> implements EmervoluService{

    @Autowired
    private EmervoluRepository emervoluRepository;

    @Override
    public CrudRepository<Emervolu, Long> getRepository(){
        return emervoluRepository;
    }
    
}