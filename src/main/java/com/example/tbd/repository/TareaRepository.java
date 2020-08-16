package com.example.tbd.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.tbd.model.Tarea;

public interface TareaRepository extends CrudRepository<Tarea, Long> {

}