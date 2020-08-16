package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Tarea;
import com.example.tbd.repository.TareaRepository;
import com.example.tbd.service.TareaService;

@Service
public class TareaServiceImpl extends GenericServiceImpl<Tarea, Long> implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public CrudRepository<Tarea, Long> getRepository(){
        return tareaRepository;
    }
    
}