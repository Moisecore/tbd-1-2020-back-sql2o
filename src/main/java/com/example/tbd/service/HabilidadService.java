package com.example.tbd.service;

import com.example.tbd.model.Habilidad;
import com.example.tbd.model.Voluntario;
import com.example.tbd.repository.DatabaseContext;
import com.example.tbd.repository.HabilidadRepository;
import com.example.tbd.threading.HabilidadThread;
import com.example.tbd.threading.VoluntarioThread;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;
    private HabilidadThread[] habilidadThread = new HabilidadThread[DatabaseContext.cantDatabases];
    private final Object[] respuestas = new Object[DatabaseContext.cantDatabases];
    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    // Obtener todas las habilidades (Read)
    @GetMapping("/habilidad")
    public List<Habilidad> getAllHabilidades() throws Exception{
        //return habilidadRepository.getAllHabilidades();

        List<Habilidad> respuesta = new ArrayList<>();
        int i;
        int dbs = DatabaseContext.cantDatabases;

        for(i = 0; i < dbs; i++){
            habilidadThread[i] = new HabilidadThread(this.habilidadRepository, i, "getAll");
            habilidadThread[i].start();
        }
        for(i = 0; i < dbs; i++){
            habilidadThread[i].join();
            respuestas[i] = habilidadThread[i].getRetorno();
        }
        for(i = 0; i < dbs; i++){
            respuesta.addAll((List)respuestas[i]);
        }
        Collections.sort(respuesta, new Comparator<Habilidad>(){
            public int compare(Habilidad v1, Habilidad v2){
                if(v1.getId() == v2.getId())
                    return 0;
                return v1.getId() < v2.getId() ? -1 : 1;
            }
        });

        return respuesta;
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
