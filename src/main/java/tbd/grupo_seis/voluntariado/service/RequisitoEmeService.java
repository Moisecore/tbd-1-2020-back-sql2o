package tbd.grupo_seis.voluntariado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd.grupo_seis.voluntariado.data.RequisitoEme;
import tbd.grupo_seis.voluntariado.repository.RequisitoEmeRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class RequisitoEmeService {

    @Autowired
    private RequisitoEmeRepository requisito_emeRepository;

    public Iterable<RequisitoEme> findAll(){
        return requisito_emeRepository.findAll();
    }

    public RequisitoEme findById(Integer id){
        return requisito_emeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public RequisitoEme save(RequisitoEme requisito_eme){
        return requisito_emeRepository.save(requisito_eme);
    }

    public void deleteById(Integer id){
        requisito_emeRepository.deleteById(id);
    }

}
