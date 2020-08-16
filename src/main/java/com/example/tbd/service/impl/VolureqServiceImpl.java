package com.example.tbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tbd.commons.GenericServiceImpl;
import com.example.tbd.model.Volureq;
import com.example.tbd.repository.VolureqRepository;
import com.example.tbd.service.VolureqService;

@Service
public class VolureqServiceImpl extends GenericServiceImpl<Volureq, Long> implements VolureqService{

    @Autowired
    private VolureqRepository volureqRepository;

    @Override
    public CrudRepository<Volureq, Long> getRepository(){
        return volureqRepository;
    }
    
}