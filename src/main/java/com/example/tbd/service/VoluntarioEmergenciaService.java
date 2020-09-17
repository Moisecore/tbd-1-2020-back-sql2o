package com.example.tbd.service;

import com.example.tbd.model.VoluntarioEmergencia;
import com.example.tbd.repository.VoluntarioEmergenciaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioEmergenciaService {

    private final VoluntarioEmergenciaRepository voluntarioEmergenciaRepository;
    VoluntarioEmergenciaService(VoluntarioEmergenciaRepository voluntarioEmergenciaRepository){
        this.voluntarioEmergenciaRepository = voluntarioEmergenciaRepository;
    }

    // Obtener todos los voluntarioEmergencia (Read)
    @GetMapping("/voluntarioEmergencia")
    public List<VoluntarioEmergencia> getAllVoluntarioEmergencia() {
        return voluntarioEmergenciaRepository.getAllVoluntarioEmergencia();
    }

    // Obtener un voluntarioEmergencia por id (Read)
    @GetMapping("/voluntarioEmergencia/{id}")
    public VoluntarioEmergencia getVoluntarioEmergenciaById(@PathVariable("id") int id){
        return voluntarioEmergenciaRepository.getVoluntarioEmergenciaById(id);
    }

    // Crear un voluntarioEmergencia nuevo (Create)
    @PostMapping("/voluntarioEmergencia")
    @ResponseBody
    public VoluntarioEmergencia createVoluntarioEmergencia(
            @RequestBody VoluntarioEmergencia voluntarioEmergencia){
        return voluntarioEmergenciaRepository.createVoluntarioEmergencia(voluntarioEmergencia);
    }

    // Cambiar datos de un voluntarioEmergencia existente (Update)
    @PutMapping("/voluntarioEmergencia/{id}")
    @ResponseBody
    public VoluntarioEmergencia updateVoluntarioEmergencia(@PathVariable("id") int id,
                                                         @RequestBody VoluntarioEmergencia voluntarioEmergencia){
        return voluntarioEmergenciaRepository.updateVoluntarioEmergencia(id, voluntarioEmergencia);
    }

    // "Elimina" un voluntarioEmergencia por id (Delete) (sólo lo desactiva)
    @DeleteMapping("/voluntarioEmergencia/{id}")
    public int deleteVoluntarioEmergenciaById(@PathVariable("id") int id){
        return voluntarioEmergenciaRepository.deleteVoluntarioEmergenciaById(id);
    }

}
