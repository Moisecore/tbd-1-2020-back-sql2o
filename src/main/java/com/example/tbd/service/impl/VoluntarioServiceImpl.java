package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Voluntario;
import com.example.tbd.repository.VoluntarioRepository;
import com.example.tbd.service.VoluntarioService;

@Service
public class VoluntarioServiceImpl extends GenericServiceImpl<Voluntario, Long> implements VoluntarioService{

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Override
    public CrudRepository<Voluntario, Long> getRepository(){
        return voluntarioRepository;
    }
    
}