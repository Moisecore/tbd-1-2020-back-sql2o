package com.example.tbd.repository;

import com.example.tbd.model.Emergencia;
import com.example.tbd.model.Voluntario;
import com.example.tbd.model.VoluntarioEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioEmergenciaRepositoryImp implements VoluntarioEmergenciaRepository{

    //@Autowired
    private Sql2o sql2o;

    public VoluntarioEmergenciaRepositoryImp(){
        this.sql2o = new Sql2o(
                "jdbc:postgresql://127.0.0.1:5432/voluntariado-sql2o",
                "postgres",
                "passgreSQL13");
    }

    // Obtener todos los voluntarioEmergencia (Read)
    @Override
    public List<VoluntarioEmergencia> getAllVoluntarioEmergencia() {
        String sql = "SELECT * " +
                "FROM voluntarioemergencia " +
                "ORDER BY id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(VoluntarioEmergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Obtener un voluntarioEmergencia por id (Read)
    @Override
    public VoluntarioEmergencia getVoluntarioEmergenciaById(int id){
        String sql = "SELECT * " +
                "FROM voluntarioemergencia " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioEmergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Crear un voluntarioEmergencia nuevo (Create)
    @Override
    public VoluntarioEmergencia createVoluntarioEmergencia(VoluntarioEmergencia voluntarioEmergencia) {
        String sql = "INSERT INTO voluntarioemergencia (idvoluntario, idemergencia, flagparticipa, activo) " +
                "VALUES (:idvoluntario, :idemergencia, true, true)";

        try(Connection conn = sql2o.open()){
            Voluntario vol = conn.createQuery("SELECT * " +
                    "FROM voluntario WHERE id = :idvoluntario")
                    .addParameter("idvoluntario", voluntarioEmergencia.getIdvoluntario())
                    .executeAndFetchFirst(Voluntario.class);
            if(vol == null){
                System.out.println("Error: idvoluntario no existe");
                return null;
            }

            Emergencia eme = conn.createQuery("SELECT * " +
                    "FROM emergencia WHERE id = :idemergencia")
                    .addParameter("idemergencia", voluntarioEmergencia.getIdemergencia())
                    .executeAndFetchFirst(Emergencia.class);
            if(eme == null){
                System.out.println("Error: idemergencia no existe");
                return null;
            }

            VoluntarioEmergencia volEme = conn.createQuery("SELECT * " +
                    "FROM voluntarioemergencia " +
                    "WHERE idvoluntario = :idvoluntario " +
                    "AND idemergencia = :idemergencia")
                    .addParameter("idvoluntario", voluntarioEmergencia.getIdvoluntario())
                    .addParameter("idemergencia", voluntarioEmergencia.getIdemergencia())
                    .executeAndFetchFirst(VoluntarioEmergencia.class);
            if(volEme != null){
                System.out.println("Error: relacion Voluntario-Emergencia ya existe");
                return volEme;
            }

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("idvoluntario", voluntarioEmergencia.getIdvoluntario())
                    .addParameter("idemergencia", voluntarioEmergencia.getIdemergencia())
                    .executeUpdate()
                    .getKey();
            voluntarioEmergencia.setId(insertedId);
            return voluntarioEmergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Cambiar datos de un voluntarioEmergencia existente (Update)
    @Override
    public VoluntarioEmergencia updateVoluntarioEmergencia(int id, VoluntarioEmergencia voluntarioEmergencia){
        String sql = "UPDATE voluntarioemergencia " +
                "SET idvoluntario = :idvoluntario, " +
                "idemergencia = :idemergencia" +
                "flagparticipa = :flagparticipa" +
                "activo = :activo " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            VoluntarioEmergencia volEme = conn.createQuery("SELECT * " +
                    "FROM voluntarioemergencia WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioEmergencia.class);
            Integer idVol = voluntarioEmergencia.getIdvoluntario();
            Integer idEme = voluntarioEmergencia.getIdemergencia();
            Boolean part = voluntarioEmergencia.getFlagparticipa();
            Boolean act = voluntarioEmergencia.getActivo();
            if(volEme != null){
                if(idVol == null){
                    idVol = volEme.getIdvoluntario();
                }
                if(idEme == null){
                    idEme = volEme.getIdemergencia();
                }
                if(part == null){
                    part = volEme.getFlagparticipa();
                }
                if(act == null){
                    act = volEme.getActivo();
                }
            }
            int updatedId = (int) conn.createQuery(sql)
                    .addParameter("idvoluntario", idVol)
                    .addParameter("idemergencia", idEme)
                    .addParameter("flagparticipa", part)
                    .addParameter("activo", act)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getKey();
            voluntarioEmergencia.setId(updatedId);
            voluntarioEmergencia.setIdvoluntario(idVol);
            voluntarioEmergencia.setIdemergencia(idEme);
            voluntarioEmergencia.setFlagparticipa(part);
            voluntarioEmergencia.setActivo(act);
            return voluntarioEmergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // "Elimina" un voluntarioEmergencia por id (Delete) (sólo lo desactiva)
    @Override
    public int deleteVoluntarioEmergenciaById(int id){
        String sql = "UPDATE voluntarioemergencia " +
                "SET activo = false " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            int deletedId = (int) conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getKey();
            return deletedId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
