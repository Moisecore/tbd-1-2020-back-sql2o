package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Requisito;
import com.example.tbd.repository.RequisitoRepository;
import com.example.tbd.service.RequisitoService;

@Service
public class RequisitoServiceImpl extends GenericServiceImpl<Requisito, Long> implements RequisitoService{

    @Autowired
    private RequisitoRepository requisitoRepository;

    @Override
    public CrudRepository<Requisito, Long> getRepository(){
        return requisitoRepository;
    }
    
}