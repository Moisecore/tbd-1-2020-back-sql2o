package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Requisitoeme;
import com.example.tbd.repository.RequisitoemeRepository;
import com.example.tbd.service.RequisitoemeService;

@Service
public class RequisitoemeServiceImpl extends GenericServiceImpl<Requisitoeme, Long> implements RequisitoemeService{

    @Autowired
    private RequisitoemeRepository requisitoemeRepository;

    @Override
    public CrudRepository<Requisitoeme, Long> getRepository(){
        return requisitoemeRepository;
    }
    
}