package com.example.tbd.service;

import com.example.tbd.model.Voluntario;
import com.example.tbd.repository.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService{

    private final VoluntarioRepository voluntarioRepository;
    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    // Obtener todos los voluntarios (Read)
    @GetMapping("/voluntario")
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.getAllVoluntarios();
    }

    // Obtener un voluntario por id (Read)
    @GetMapping("/voluntario/{id}")
    public Voluntario getVoluntarioById(@PathVariable("id") int id){
        return voluntarioRepository.getVoluntarioById(id);
    }

    // Crear un voluntario nuevo (Create)
    @PostMapping("/voluntario")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioRepository.createVoluntario(voluntario);
    }

    // Cambiar datos de un voluntario existente (Update)
    @PutMapping("/voluntario/{id}")
    @ResponseBody
    public Voluntario updateVoluntario(@PathVariable("id") int id,
                                       @RequestBody Voluntario voluntario){
        return voluntarioRepository.updateVoluntario(id, voluntario);
    }

    // "Elimina" un voluntario por id (Delete) (sólo lo desactiva)
    @DeleteMapping("/voluntario/{id}")
    public int deleteVoluntarioById(@PathVariable("id") int id){
        return voluntarioRepository.deleteVoluntarioById(id);
    }

}