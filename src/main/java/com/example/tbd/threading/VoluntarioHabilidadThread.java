package com.example.tbd.threading;

import com.example.tbd.repository.VoluntarioHabilidadRepository;

public class VoluntarioHabilidadThread extends Thread{

    private final VoluntarioHabilidadRepository voluntarioHabilidadRepository;
    private int databaseNumber;
    private String funcType;
    private Object retorno;

    public VoluntarioHabilidadThread(VoluntarioHabilidadRepository voluntarioHabilidadRepository, int i, String func){
        this.voluntarioHabilidadRepository = voluntarioHabilidadRepository;
        this.databaseNumber = i;
        this.funcType = func;
    }

    public void run(){
        try{

            switch (funcType){
                case "getAll":
                    retorno = voluntarioHabilidadRepository.getAllVoluntarioHabilidad(this.databaseNumber);
                    break;
            }

        } catch(Exception e){
            System.out.println("Ocurrio un error en VoluntarioHabilidadThread");
        }
    }

    public int getDatabaseNumber() {
        return databaseNumber;
    }

    public void setDatabaseNumber(int databaseNumber) {
        this.databaseNumber = databaseNumber;
    }

    public Object getRetorno() {
        return retorno;
    }

    public void setRetorno(Object retorno) {
        this.retorno = retorno;
    }

}
