package tbd.grupo_seis.voluntariado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.grupo_seis.voluntariado.data.Tarea;
import tbd.grupo_seis.voluntariado.service.TareaService;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public Iterable<Tarea> findAll(){
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public Tarea findById(@PathVariable Integer id){
        return tareaService.findById(id);
    }

    @PostMapping("/create")
    public Tarea create(@RequestBody Tarea tarea){
        return tareaService.save(tarea);
    }

    @PutMapping("/update/{id}")
    public Tarea update(@RequestBody Tarea tarea, @PathVariable Integer id){
        tarea.setId(id);
        return tareaService.save(tarea);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        //tareaService.deleteById(id);
        // Se reemplaza por cambiar a inactivo, para no borrarlo de la BD
        Tarea tarea = findById(id);
        //tarea.setEstado(false);
        tareaService.save(tarea);
    }

}
