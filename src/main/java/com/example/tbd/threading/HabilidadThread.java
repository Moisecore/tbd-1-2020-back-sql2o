package com.example.tbd.threading;

import com.example.tbd.repository.HabilidadRepository;

public class HabilidadThread extends Thread{

    private final HabilidadRepository habilidadRepository;
    private int databaseNumber;
    private String funcType;
    private Object retorno;

    public HabilidadThread(HabilidadRepository habilidadRepository, int i, String func){
        this.habilidadRepository = habilidadRepository;
        this.databaseNumber = i;
        this.funcType = func;
    }

    public void run(){
        try{

            switch (funcType){
                case "getAll":
                    retorno = habilidadRepository.getAllHabilidades(this.databaseNumber);
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
