package com.example.tbd.model;

public class VoluntarioEmergencia {

    private int id;
    private int idvoluntario;
    private int idemergencia;
    private boolean flagparticipa = true;
    private boolean activo = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdvoluntario() {
        return idvoluntario;
    }

    public void setIdvoluntario(int idvoluntario) {
        this.idvoluntario = idvoluntario;
    }

    public int getIdemergencia() {
        return idemergencia;
    }

    public void setIdemergencia(int idemergencia) {
        this.idemergencia = idemergencia;
    }

    public boolean getFlagparticipa() {
        return flagparticipa;
    }

    public void setFlagparticipa(boolean flagparticipa) {
        this.flagparticipa = flagparticipa;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
