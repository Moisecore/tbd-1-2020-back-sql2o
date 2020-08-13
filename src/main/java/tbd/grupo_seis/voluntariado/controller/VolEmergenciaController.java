package tbd.grupo_seis.voluntariado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.grupo_seis.voluntariado.data.VolEmergencia;
import tbd.grupo_seis.voluntariado.service.VolEmergenciaService;

public class VolEmergenciaController {
    @Autowired
    private VolEmergenciaService vol_emergenciaService;

    @GetMapping
    public Iterable<VolEmergencia> findAll(){
        return vol_emergenciaService.findAll();
    }

    @GetMapping("/{id}")
    public VolEmergencia findById(@PathVariable Integer id){
        return vol_emergenciaService.findById(id);
    }

    @PostMapping
    public VolEmergencia create(@RequestBody VolEmergencia vol_emergencia){
        return vol_emergenciaService.save(vol_emergencia);
    }

    @PutMapping("/{id}")
    public VolEmergencia update(@RequestBody VolEmergencia vol_emergencia, @PathVariable Integer id){
        vol_emergencia.setId(id);
        return vol_emergenciaService.save(vol_emergencia);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        //vol_emergenciaService.deleteById(id);
        // Se reemplaza por cambiar a inactivo, para no borrarlo de la BD
        VolEmergencia vol_emergencia = findById(id);
        vol_emergencia.setActivo(false);
        vol_emergenciaService.save(vol_emergencia);
    }
}
