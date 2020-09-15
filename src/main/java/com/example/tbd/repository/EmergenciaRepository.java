package com.example.tbd.repository;

import com.example.tbd.model.Emergencia;
import java.util.List;

public interface EmergenciaRepository {

    public List<Emergencia> getAllEmergencias();
    public Emergencia getEmergenciaById(int id);
    public Emergencia createEmergencia(Emergencia emergencia);
    public Emergencia updateEmergencia(int id, Emergencia emergencia);
    public int deleteEmergenciaById(int id);

}