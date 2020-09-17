package com.example.tbd.repository;

import com.example.tbd.model.VoluntarioHabilidad;
import java.util.List;

public interface VoluntarioHabilidadRepository {

    public List<VoluntarioHabilidad> getAllVoluntarioHabilidad(int i);
    public VoluntarioHabilidad getVoluntarioHabilidadById(int id);
    public VoluntarioHabilidad createVoluntarioHabilidad(VoluntarioHabilidad voluntarioHabilidad);
    public VoluntarioHabilidad updateVoluntarioHabilidad(int id, VoluntarioHabilidad voluntarioHabilidad);
    public int deleteVoluntarioHabilidadById(int id);

}
