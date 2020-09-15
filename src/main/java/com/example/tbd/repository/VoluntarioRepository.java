package com.example.tbd.repository;

import com.example.tbd.model.Voluntario;
import java.util.List;

public interface VoluntarioRepository {

    public List<Voluntario> getAllVoluntarios();
    public Voluntario getVoluntarioById(int id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public Voluntario updateVoluntario(int id, Voluntario voluntario);
    public int deleteVoluntarioById(int id);

}