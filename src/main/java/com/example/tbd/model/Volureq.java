package com.example.tbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Volureq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idvoluntario;

    @Column
    private Long idrequisito;

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

    public Long getIdrequisito() {
        return idrequisito;
    }

    public void setIdrequisito(Long idrequisito) {
        this.idrequisito = idrequisito;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}



