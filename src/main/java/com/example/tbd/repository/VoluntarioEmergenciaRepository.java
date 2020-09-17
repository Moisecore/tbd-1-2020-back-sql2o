package com.example.tbd.repository;

import com.example.tbd.model.VoluntarioEmergencia;

import java.util.List;

public interface VoluntarioEmergenciaRepository {

    public List<VoluntarioEmergencia> getAllVoluntarioEmergencia();
    public VoluntarioEmergencia getVoluntarioEmergenciaById(int id);
    public VoluntarioEmergencia createVoluntarioEmergencia(VoluntarioEmergencia voluntarioEmergencia);
    public VoluntarioEmergencia updateVoluntarioEmergencia(int id, VoluntarioEmergencia voluntarioEmergencia);
    public int deleteVoluntarioEmergenciaById(int id);

}
