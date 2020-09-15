package com.example.tbd.service;

import com.example.tbd.model.Emergencia;
import com.example.tbd.repository.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    // Obtener todas las emergencias (Read)
    @GetMapping("/emergencia")
    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.getAllEmergencias();
    }

    // Obtener una emergencia por id (Read)
    @GetMapping("/emergencia/{id}")
    public Emergencia getEmergenciaById(@PathVariable("id") int id){
        return emergenciaRepository.getEmergenciaById(id);
    }

    // Crear una emergencia nueva (Create)
    @PostMapping("/emergencia")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaRepository.createEmergencia(emergencia);
    }

    // Cambiar datos de una emergencia existente (Update)
    @PutMapping("/emergencia/{id}")
    @ResponseBody
    public Emergencia updateEmergencia(@PathVariable("id") int id,
                                       @RequestBody Emergencia emergencia){
        return emergenciaRepository.updateEmergencia(id, emergencia);
    }

    // "Elimina" una emergencia por id (Delete) (sólo la desactiva)
    @DeleteMapping("/emergencia/{id}")
    public int deleteEmergenciaById(@PathVariable("id") int id){
        return emergenciaRepository.deleteEmergenciaById(id);
    }

}