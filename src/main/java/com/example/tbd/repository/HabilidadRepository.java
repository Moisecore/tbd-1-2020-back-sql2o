package com.example.tbd.repository;

import com.example.tbd.model.Habilidad;
import java.util.List;

public interface HabilidadRepository {

    public List<Habilidad> getAllHabilidades(int i);
    public Habilidad getHabilidadById(int id);
    public Habilidad createHabilidad(Habilidad habilidad);
    public Habilidad updateHabilidad(int id, Habilidad habilidad);
    public int deleteHabilidadById(int id);

}
