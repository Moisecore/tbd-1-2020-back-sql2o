package com.example.tbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Requisitoeme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idrequisito;

    @Column
    private Long idemergencia;

    @Column
    private Boolean activo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdrequisito() {
        return idrequisito;
    }

    public void setIdrequisito(Long idrequisito) {
        this.idrequisito = idrequisito;
    }

    public Long getIdemergencia() {
        return idemergencia;
    }

    public void setIdemergencia(Long idemergencia) {
        this.idemergencia = idemergencia;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}



