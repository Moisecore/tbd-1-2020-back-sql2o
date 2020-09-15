package com.example.tbd.service;

import com.example.tbd.model.VoluntarioHabilidad;
import com.example.tbd.repository.VoluntarioHabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioHabilidadService {

    private final VoluntarioHabilidadRepository voluntarioHabilidadRepository;
    VoluntarioHabilidadService(VoluntarioHabilidadRepository voluntarioHabilidadRepository){
        this.voluntarioHabilidadRepository = voluntarioHabilidadRepository;
    }

    // Obtener todos los voluntarioHabilidad (Read)
    @GetMapping("/voluntarioHabilidad")
    public List<VoluntarioHabilidad> getAllVoluntarioHabilidad() {
        return voluntarioHabilidadRepository.getAllVoluntarioHabilidad();
    }

    // Obtener un voluntarioHabilidad por id (Read)
    @GetMapping("/voluntarioHabilidad/{id}")
    public VoluntarioHabilidad getVoluntarioHabilidadById(@PathVariable("id") int id){
        return voluntarioHabilidadRepository.getVoluntarioHabilidadById(id);
    }

    // Crear un voluntarioHabilidad nuevo (Create)
    @PostMapping("/voluntarioHabilidad")
    @ResponseBody
    public VoluntarioHabilidad createVoluntarioHabilidad(
            @RequestBody VoluntarioHabilidad voluntarioHabilidad){
        return voluntarioHabilidadRepository.createVoluntarioHabilidad(voluntarioHabilidad);
    }

    // Cambiar datos de un voluntarioHabilidad existente (Update)
    @PutMapping("/voluntarioHabilidad/{id}")
    @ResponseBody
    public VoluntarioHabilidad updateVoluntarioHabilidad(@PathVariable("id") int id,
                                       @RequestBody VoluntarioHabilidad voluntarioHabilidad){
        return voluntarioHabilidadRepository.updateVoluntarioHabilidad(id, voluntarioHabilidad);
    }

    // "Elimina" un voluntarioHabilidad por id (Delete) (sólo lo desactiva)
    @DeleteMapping("/voluntarioHabilidad/{id}")
    public int deleteVoluntarioHabilidadById(@PathVariable("id") int id){
        return voluntarioHabilidadRepository.deleteVoluntarioHabilidadById(id);
    }

}
