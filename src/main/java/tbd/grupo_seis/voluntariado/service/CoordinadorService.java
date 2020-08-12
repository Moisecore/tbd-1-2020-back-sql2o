package tbd.grupo_seis.voluntariado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd.grupo_seis.voluntariado.data.Coordinador;
import tbd.grupo_seis.voluntariado.repository.CoordinadorRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class CoordinadorService {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    public Iterable<Coordinador> findAll(){
        return coordinadorRepository.findAll();
    }

    public Coordinador findById(Integer id){
        return coordinadorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Coordinador save(Coordinador coordinador){
        return coordinadorRepository.save(coordinador);
    }

    public void deleteById(Integer id){
        coordinadorRepository.deleteById(id);
    }

}
