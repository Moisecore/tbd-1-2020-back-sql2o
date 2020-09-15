package com.example.tbd.service;

import com.example.tbd.model.Habilidad;
import com.example.tbd.repository.HabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;
    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    // Obtener todas las habilidades (Read)
    @GetMapping("/habilidad")
    public List<Habilidad> getAllHabilidades() {
        return habilidadRepository.getAllHabilidades();
    }

    // Obtener una habilidad por id (Read)
    @GetMapping("/habilidad/{id}")
    public Habilidad getHabilidadById(@PathVariable("id") int id){
        return habilidadRepository.getHabilidadById(id);
    }

    // Crear una habilidad nueva (Create)
    @PostMapping("/habilidad")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        return habilidadRepository.createHabilidad(habilidad);
    }

    // Cambiar datos de una habilidad existente (Update)
    @PutMapping("/habilidad/{id}")
    @ResponseBody
    public Habilidad updateHabilidad(@PathVariable("id") int id,
                                       @RequestBody Habilidad habilidad){
        return habilidadRepository.updateHabilidad(id, habilidad);
    }

    // "Elimina" una habilidad por id (Delete) (sólo la desactiva)
    @DeleteMapping("/habilidad/{id}")
    public int deleteHabilidadById(@PathVariable("id") int id){
        return habilidadRepository.deleteHabilidadById(id);
    }

}
