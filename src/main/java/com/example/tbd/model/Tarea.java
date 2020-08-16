package com.example.tbd.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idvoluntario;

    @Column
    private Long idemergencia;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Date inicio;

    @Column
    private Date fin;

    @Column
    private Boolean estado = true;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}



