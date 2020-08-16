package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Emergencia;
import com.example.tbd.repository.EmergenciaRepository;
import com.example.tbd.service.EmergenciaService;

@Service
public class EmergenciaServiceImpl extends GenericServiceImpl<Emergencia, Long> implements EmergenciaService{

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    @Override
    public CrudRepository<Emergencia, Long> getRepository(){
        return emergenciaRepository;
    }
    
}