package com.example.tbd.repository;

import com.example.tbd.model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    // Obtener todas las habilidades (Read)
    @Override
    public List<Habilidad> getAllHabilidades() {
        String sql = "SELECT * " +
                "FROM habilidad " +
                "ORDER BY id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Obtener una habilidad por id (Read)
    @Override
    public Habilidad getHabilidadById(int id){
        String sql = "SELECT * " +
                "FROM habilidad " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Crear una habilidad nueva (Create)
    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        String sql = "INSERT INTO habilidad (descripcion, activo) " +
                "VALUES (:descripcion, true)";

        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .executeUpdate()
                    .getKey();
            habilidad.setId(insertedId);
            return habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Cambiar datos de una habilidad existente (Update)
    @Override
    public Habilidad updateHabilidad(int id, Habilidad habilidad){
        String sql = "UPDATE habilidad " +
                "SET descripcion = :descripcion, activo = :activo " +
                "WHERE id = :id";

        try(Connection conn = sql2o.open()){
            Habilidad hab = conn.createQuery("SELECT * " +
                    "FROM habilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
            String desc = habilidad.getDescripcion();
            Boolean act = habilidad.getActivo();
            if(hab != null){
                if(desc == null){
                    desc = hab.getDescripcion();
                }
                if(act == null){
                    act = hab.getActivo();
                }
            }
            int updatedId = (int) conn.createQuery(sql)
                    .addParameter("descripcion", desc)
                    .addParameter("activo", act)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getKey();
            habilidad.setId(updatedId);
            habilidad.setDescripcion(desc);
            habilidad.setActivo(act);
            return habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // "Elimina" una habilidad por id (Delete) (sólo la desactiva)
    @Override
    public int deleteHabilidadById(int id){
        String sql = "UPDATE habilidad " +
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
