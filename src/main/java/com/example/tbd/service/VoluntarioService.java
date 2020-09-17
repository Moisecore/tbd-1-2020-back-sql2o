package com.example.tbd.service;

import com.example.tbd.model.Voluntario;
import com.example.tbd.repository.DatabaseContext;
import com.example.tbd.repository.VoluntarioRepository;
import com.example.tbd.threading.VoluntarioThread;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService{

    private final VoluntarioRepository voluntarioRepository;
    private VoluntarioThread[] voluntarioThread = new VoluntarioThread[DatabaseContext.cantDatabases];
    private final Object[] respuestas = new Object[DatabaseContext.cantDatabases];
    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    // Obtener todos los voluntarios (Read)
    @GetMapping("/voluntario")
    public List<Voluntario> getAllVoluntarios() throws Exception{
        //return voluntarioRepository.getAllVoluntarios();

        List<Voluntario> respuesta = new ArrayList<>();
        int i;
        int dbs = DatabaseContext.cantDatabases;

        for(i = 0; i < dbs; i++){
            voluntarioThread[i] = new VoluntarioThread(this.voluntarioRepository, i, "getAll", -1);
            voluntarioThread[i].start();
        }
        for(i = 0; i < dbs; i++){
            voluntarioThread[i].join();
            respuestas[i] = voluntarioThread[i].getRetorno();
        }
        for(i = 0; i < dbs; i++){
            respuesta.addAll((List)respuestas[i]);
        }
        Collections.sort(respuesta, new Comparator<Voluntario>(){
            public int compare(Voluntario v1, Voluntario v2){
                if(v1.getId() == v2.getId())
                    return 0;
                return v1.getId() < v2.getId() ? -1 : 1;
            }
        });

        return respuesta;
    }

    // Obtener un voluntario por id (Read)
    @GetMapping("/voluntario/{id}")
    public Voluntario getVoluntarioById(@PathVariable("id") int id) throws Exception{
        //return voluntarioRepository.getVoluntarioById(id);

        Voluntario respuesta = null;
        int i;
        int dbs = DatabaseContext.cantDatabases;

        for(i = 0; i < dbs; i++){
            voluntarioThread[i] = new VoluntarioThread(this.voluntarioRepository, i, "getById", id);
            voluntarioThread[i].start();
        }
        for(i = 0; i < dbs; i++){
            voluntarioThread[i].join();
            respuestas[i] = voluntarioThread[i].getRetorno();
        }
        for(i = 0; i < dbs; i++){
            if(respuestas[i] != null){
                respuesta = (Voluntario) respuestas[i];
                break;
            }
        }

        return respuesta;
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
    public int deleteVoluntarioById(@PathVariable("id") int id) throws Exception{
        //return voluntarioRepository.deleteVoluntarioById(id);

        int respuesta = -2;
        int i;
        int dbs = DatabaseContext.cantDatabases;

        for(i = 0; i < dbs; i++){
            voluntarioThread[i] = new VoluntarioThread(this.voluntarioRepository, i, "deleteById", id);
            voluntarioThread[i].start();
        }
        for(i = 0; i < dbs; i++){
            voluntarioThread[i].join();
            respuestas[i] = voluntarioThread[i].getRetorno();
        }
        for(i = 0; i < dbs; i++){
            if(respuestas[i] != null){
                respuesta = (int) respuestas[i];
                break;
            }
        }

        return respuesta;
    }

}