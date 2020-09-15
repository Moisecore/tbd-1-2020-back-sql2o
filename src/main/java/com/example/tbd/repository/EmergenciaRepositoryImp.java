package com.example.tbd.repository;

import com.example.tbd.model.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    // Obtener todas las emergencias (Read)
    @Override
    public List<Emergencia> getAllEmergencias() {
        String sql = "SELECT * " +
                "FROM emergencia " +
                "ORDER BY id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Obtener una emergencia por id (Read)
    @Override
    public Emergencia getEmergenciaById(int id){
        String sql = "SELECT * " +
                "FROM emergencia " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Crear una emergencia nueva (Create)
    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        String sql = "INSERT INTO emergencia (nombre, descripcion, activo) " +
                "VALUES (:nombre, :descripcion, true)";

        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .executeUpdate()
                    .getKey();
            emergencia.setId(insertedId);
            return emergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Cambiar datos de una emergencia existente (Update)
    @Override
    public Emergencia updateEmergencia(int id, Emergencia emergencia){
        String sql = "UPDATE emergencia " +
                "SET nombre = :nombre, descripcion = :descripcion, activo = :activo " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            Emergencia eme = conn.createQuery("SELECT * " +
                    "FROM emergencia WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            String nom = emergencia.getNombre();
            String desc = emergencia.getDescripcion();
            Boolean act = emergencia.getActivo();
            if(eme != null){
                if(nom == null){
                    nom = eme.getNombre();
                }
                if(desc == null){
                    desc = eme.getDescripcion();
                }
                if(act == null){
                    act = eme.getActivo();
                }
            }
            int updatedId = (int) conn.createQuery(sql)
                    .addParameter("nombre", nom)
                    .addParameter("descripcion", desc)
                    .addParameter("activo", act)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getKey();
            emergencia.setId(updatedId);
            emergencia.setNombre(nom);
            emergencia.setDescripcion(desc);
            emergencia.setActivo(act);
            return emergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // "Elimina" una emergencia por id (Delete) (sólo la desactiva)
    @Override
    public int deleteEmergenciaById(int id){
        String sql = "UPDATE emergencia " +
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
