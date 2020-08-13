package tbd.grupo_seis.voluntariado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbd.grupo_seis.voluntariado.data.VolEmergencia;
import tbd.grupo_seis.voluntariado.repository.VolEmergenciaRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class VolEmergenciaService {

    @Autowired
    private VolEmergenciaRepository vol_emergenciaRepository;

    public Iterable<VolEmergencia> findAll(){
        return vol_emergenciaRepository.findAll();
    }

    public VolEmergencia findById(Integer id){
        return vol_emergenciaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public VolEmergencia save(VolEmergencia vol_emergencia){
        return vol_emergenciaRepository.save(vol_emergencia);
    }

    public void deleteById(Integer id){
        vol_emergenciaRepository.deleteById(id);
    }
}
