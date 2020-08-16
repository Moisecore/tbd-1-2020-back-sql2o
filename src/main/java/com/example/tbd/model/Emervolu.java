package com.example.tbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Emervolu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idvoluntario;

    @Column
    private Long idemergencia;

    @Column
    private Long ranking;

    @Column
    private Boolean participa = true;

    @Column
    private Boolean activo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdvoluntario() {
        return idvoluntario;
    }

    public void setIdvoluntario(Long idvoluntario) {
        this.idvoluntario = idvoluntario;
    }

    public Long getIdemergencia() {
        return idemergencia;
    }

    public void setIdemergencia(Long idemergencia) {
        this.idemergencia = idemergencia;
    }

    public Long getRanking() {
        return ranking;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    public Boolean getParticipa() {
        return participa;
    }

    public void setParticipa(Boolean participa) {
        this.participa = participa;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}



