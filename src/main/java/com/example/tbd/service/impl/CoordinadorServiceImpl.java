package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Coordinador;
import com.example.tbd.repository.CoordinadorRepository;
import com.example.tbd.service.CoordinadorService;

@Service
public class CoordinadorServiceImpl extends GenericServiceImpl<Coordinador, Long> implements CoordinadorService{

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Override
    public CrudRepository<Coordinador, Long> getRepository(){
        return coordinadorRepository;
    }
    
}