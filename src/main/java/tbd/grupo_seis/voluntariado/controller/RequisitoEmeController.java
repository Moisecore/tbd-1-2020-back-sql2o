package tbd.grupo_seis.voluntariado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.grupo_seis.voluntariado.data.RequisitoEme;
import tbd.grupo_seis.voluntariado.service.RequisitoEmeService;

public class RequisitoEmeController {
    @Autowired
    private RequisitoEmeService requisito_emeService;

    @GetMapping
    public Iterable<RequisitoEme> findAll(){
        return requisito_emeService.findAll();
    }

    @GetMapping("/{id}")
    public RequisitoEme findById(@PathVariable Integer id){
        return requisito_emeService.findById(id);
    }

    @PostMapping
    public RequisitoEme create(@RequestBody RequisitoEme requisito_eme){
        return requisito_emeService.save(requisito_eme);
    }

    @PutMapping("/{id}")
    public RequisitoEme update(@RequestBody RequisitoEme requisito_eme, @PathVariable Integer id){
        requisito_eme.setId(id);
        return requisito_emeService.save(requisito_eme);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        //requisito_emeService.deleteById(id);
        // Se reemplaza por cambiar a inactivo, para no borrarlo de la BD
        RequisitoEme requisito_eme = findById(id);
        requisito_eme.setActivo(false);
        requisito_emeService.save(requisito_eme);
    }
}
