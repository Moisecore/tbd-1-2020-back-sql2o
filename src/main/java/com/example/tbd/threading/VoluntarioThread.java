package com.example.tbd.threading;

import com.example.tbd.repository.VoluntarioRepository;

public class VoluntarioThread extends Thread{

    private final VoluntarioRepository voluntarioRepository;
    private int databaseNumber;
    private String funcType;
    private int id;
    private Object retorno;

    public VoluntarioThread(VoluntarioRepository voluntarioRepository, int i, String func, int id){
        this.voluntarioRepository = voluntarioRepository;
        this.databaseNumber = i;
        this.funcType = func;
        this.id = id;
    }

    public void run(){
        try{

            switch (funcType){
                case "getAll":
                    retorno = voluntarioRepository.getAllVoluntarios(this.databaseNumber);
                    break;
                case "getById":
                    retorno = voluntarioRepository.getVoluntarioById(this.databaseNumber, this.id);
                    break;
                case "deleteById":
                    retorno = voluntarioRepository.deleteVoluntarioById(this.databaseNumber, this.id);
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
