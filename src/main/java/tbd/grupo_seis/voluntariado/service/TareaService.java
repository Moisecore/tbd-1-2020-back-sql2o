package tbd.grupo_seis.voluntariado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd.grupo_seis.voluntariado.data.Tarea;
import tbd.grupo_seis.voluntariado.repository.TareaRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public Iterable<Tarea> findAll(){
        return tareaRepository.findAll();
    }

    public Tarea findById(Integer id){
        return tareaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Tarea save(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    public void deleteById(Integer id){
        tareaRepository.deleteById(id);
    }

}
