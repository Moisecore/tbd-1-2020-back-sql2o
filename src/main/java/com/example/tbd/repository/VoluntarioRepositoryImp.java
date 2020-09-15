package com.example.tbd.repository;

import com.example.tbd.model.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {

    @Autowired
    private Sql2o sql2o;

    // Obtener todos los voluntarios (Read)
    @Override
    public List<Voluntario> getAllVoluntarios() {
        String sql = "SELECT * " +
                "FROM voluntario " +
                "ORDER BY id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Obtener un voluntario por id (Read)
    @Override
    public Voluntario getVoluntarioById(int id){
        String sql = "SELECT * " +
                "FROM voluntario " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Crear un voluntario nuevo (Create)
    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        String sql = "INSERT INTO voluntario (nombre, activo) " +
                "VALUES (:nombre, true)";

        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .executeUpdate()
                    .getKey();
            voluntario.setId(insertedId);
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Cambiar datos de un voluntario existente (Update)
    @Override
    public Voluntario updateVoluntario(int id, Voluntario voluntario){
        String sql = "UPDATE voluntario " +
                "SET nombre = :nombre, activo = :activo " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            Voluntario vol = conn.createQuery("SELECT * " +
                    "FROM voluntario WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            String volNom = voluntario.getNombre();
            Boolean volAct = voluntario.getActivo();
            if(vol != null){
                if(volNom == null){
                    volNom = vol.getNombre();
                }
                if(volAct == null){
                    volAct = vol.getActivo();
                }
            }
            int updatedId = (int) conn.createQuery(sql)
                    .addParameter("nombre", volNom)
                    .addParameter("activo", volAct)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getKey();
            voluntario.setId(updatedId);
            voluntario.setNombre(volNom);
            voluntario.setActivo(volAct);
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // "Elimina" un voluntario por id (Delete) (sólo lo desactiva)
    @Override
    public int deleteVoluntarioById(int id){
        String sql = "UPDATE voluntario " +
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
