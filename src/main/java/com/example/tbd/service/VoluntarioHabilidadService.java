package com.example.tbd.service;

import com.example.tbd.model.Voluntario;
import com.example.tbd.model.VoluntarioHabilidad;
import com.example.tbd.repository.DatabaseContext;
import com.example.tbd.repository.VoluntarioHabilidadRepository;
import com.example.tbd.threading.VoluntarioHabilidadThread;
import com.example.tbd.threading.VoluntarioThread;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioHabilidadService {

    private final VoluntarioHabilidadRepository voluntarioHabilidadRepository;
    private VoluntarioHabilidadThread[] voluntarioHabilidadThread = new VoluntarioHabilidadThread[DatabaseContext.cantDatabases];
    private final Object[] respuestas = new Object[DatabaseContext.cantDatabases];
    VoluntarioHabilidadService(VoluntarioHabilidadRepository voluntarioHabilidadRepository){
        this.voluntarioHabilidadRepository = voluntarioHabilidadRepository;
    }

    // Obtener todos los voluntarioHabilidad (Read)
    @GetMapping("/voluntarioHabilidad")
    public List<VoluntarioHabilidad> getAllVoluntarioHabilidad() throws Exception{
        //return voluntarioHabilidadRepository.getAllVoluntarioHabilidad();

        List<VoluntarioHabilidad> respuesta = new ArrayList<>();
        int i;
        int dbs = DatabaseContext.cantDatabases;

        for(i = 0; i < dbs; i++){
            voluntarioHabilidadThread[i] = new VoluntarioHabilidadThread(this.voluntarioHabilidadRepository, i, "getAll");
            voluntarioHabilidadThread[i].start();
        }
        for(i = 0; i < dbs; i++){
            voluntarioHabilidadThread[i].join();
            respuestas[i] = voluntarioHabilidadThread[i].getRetorno();
        }
        for(i = 0; i < dbs; i++){
            respuesta.addAll((List)respuestas[i]);
        }
        Collections.sort(respuesta, new Comparator<VoluntarioHabilidad>(){
            public int compare(VoluntarioHabilidad v1, VoluntarioHabilidad v2){
                if(v1.getId() == v2.getId())
                    return 0;
                return v1.getId() < v2.getId() ? -1 : 1;
            }
        });

        return respuesta;
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
