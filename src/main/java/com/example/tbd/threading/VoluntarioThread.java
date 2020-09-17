package com.example.tbd.threading;

import com.example.tbd.repository.VoluntarioRepository;

public class VoluntarioThread extends Thread{

    private final VoluntarioRepository voluntarioRepository;
    private int databaseNumber;
    private String funcType;
    private Object retorno;

    public VoluntarioThread(VoluntarioRepository voluntarioRepository, int i, String func){
        this.voluntarioRepository = voluntarioRepository;
        this.databaseNumber = i;
        this.funcType = func;
    }

    public void run(){
        try{

            switch (funcType){
                case "getAll":
                    retorno = voluntarioRepository.getAllVoluntarios(this.databaseNumber);
                    break;
            }

        } catch(Exception e){
            System.out.println("Ocurrio un error en VoluntarioThread");
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
