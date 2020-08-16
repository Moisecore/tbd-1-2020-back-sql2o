package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Institucion;
import com.example.tbd.repository.InstitucionRepository;
import com.example.tbd.service.InstitucionService;

@Service
public class InstitucionServiceImpl extends GenericServiceImpl<Institucion, Long> implements InstitucionService{

    @Autowired
    private InstitucionRepository institucionRepository;

    @Override
    public CrudRepository<Institucion, Long> getRepository(){
        return institucionRepository;
    }
    
}