package tbd.grupo_seis.voluntariado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.grupo_seis.voluntariado.data.Coordinador;
import tbd.grupo_seis.voluntariado.service.CoordinadorService;

@RestController
@RequestMapping("/coordinador")
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    @GetMapping
    public Iterable<Coordinador> findAll(){
        return coordinadorService.findAll();
    }

    @GetMapping("/{id}")
    public Coordinador findById(@PathVariable Integer id){
        return coordinadorService.findById(id);
    }

    @PostMapping
    public Coordinador create(@RequestBody Coordinador coordinador){
        return coordinadorService.save(coordinador);
    }

    @PutMapping("/{id}")
    public Coordinador update(@RequestBody Coordinador coordinador, @PathVariable Integer id){
        coordinador.setId(id);
        return coordinadorService.save(coordinador);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        //coordinadorService.deleteById(id);
        // Se reemplaza por cambiar a inactivo, para no borrarlo de la BD
        Coordinador coordinador = findById(id);
        coordinador.setActivo(false);
        coordinadorService.save(coordinador);
    }

}
