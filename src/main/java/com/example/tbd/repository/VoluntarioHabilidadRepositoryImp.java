package com.example.tbd.repository;

import com.example.tbd.model.Habilidad;
import com.example.tbd.model.Voluntario;
import com.example.tbd.model.VoluntarioHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioHabilidadRepositoryImp implements VoluntarioHabilidadRepository{

    @Autowired
    private Sql2o[] sql2o;

    // Obtener todos los voluntarioHabilidad (Read)
    @Override
    public List<VoluntarioHabilidad> getAllVoluntarioHabilidad(int i) {
        String sql = "SELECT * " +
                "FROM voluntariohabilidad " +
                "ORDER BY id";

        try(Connection conn = sql2o[i].open()){
            return conn.createQuery(sql)
                    .executeAndFetch(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Obtener un voluntarioHabilidad por id (Read)
    @Override
    public VoluntarioHabilidad getVoluntarioHabilidadById(int id){
        String sql = "SELECT * " +
                "FROM voluntariohabilidad " +
                "WHERE id = :id";

        try(Connection conn = sql2o[0].open()){
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Crear un voluntarioHabilidad nuevo (Create)
    @Override
    public VoluntarioHabilidad createVoluntarioHabilidad(VoluntarioHabilidad voluntarioHabilidad) {
        String sql = "INSERT INTO voluntariohabilidad (idvoluntario, idhabilidad, activo) " +
                "VALUES (:idvoluntario, :idhabilidad, true)";

        try(Connection conn = sql2o[0].open()){
            Voluntario vol = conn.createQuery("SELECT * " +
                    "FROM voluntario WHERE id = :idvoluntario")
                    .addParameter("idvoluntario", voluntarioHabilidad.getIdvoluntario())
                    .executeAndFetchFirst(Voluntario.class);
            if(vol == null){
                System.out.println("Error: idvoluntario no existe");
                return null;
            }

            Habilidad hab = conn.createQuery("SELECT * " +
                    "FROM habilidad WHERE id = :idhabilidad")
                    .addParameter("idhabilidad", voluntarioHabilidad.getIdhabilidad())
                    .executeAndFetchFirst(Habilidad.class);
            if(hab == null){
                System.out.println("Error: idhabilidad no existe");
                return null;
            }

            VoluntarioHabilidad volHab = conn.createQuery("SELECT * " +
                    "FROM voluntariohabilidad " +
                    "WHERE idvoluntario = :idvoluntario " +
                    "AND idhabilidad = :idhabilidad")
                    .addParameter("idvoluntario", voluntarioHabilidad.getIdvoluntario())
                    .addParameter("idhabilidad", voluntarioHabilidad.getIdhabilidad())
                    .executeAndFetchFirst(VoluntarioHabilidad.class);
            if(volHab != null){
                System.out.println("Error: relacion Voluntario-Habilidad ya existe");
                return volHab;
            }

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("idvoluntario", voluntarioHabilidad.getIdvoluntario())
                    .addParameter("idhabilidad", voluntarioHabilidad.getIdhabilidad())
                    .executeUpdate()
                    .getKey();
            voluntarioHabilidad.setId(insertedId);
            return voluntarioHabilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Cambiar datos de un voluntarioHabilidad existente (Update)
    @Override
    public VoluntarioHabilidad updateVoluntarioHabilidad(int id,
                                                         VoluntarioHabilidad voluntarioHabilidad){
        String sql = "UPDATE voluntariohabilidad " +
                "SET idvoluntario = :idvoluntario, " +
                "idhabilidad = :idhabilidad, " +
                "activo = :activo " +
                "WHERE id = :id";

        try(Connection conn = sql2o[0].open()){
            VoluntarioHabilidad volHab = conn.createQuery("SELECT * " +
                    "FROM voluntariohabilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioHabilidad.class);
            Integer idv = voluntarioHabilidad.getIdvoluntario();
            Integer idh = voluntarioHabilidad.getIdhabilidad();
            Boolean act = voluntarioHabilidad.getActivo();
            if(volHab != null){
                if(idv == null){
                    idv = volHab.getIdvoluntario();
                }
                if(idh == null){
                    idh = volHab.getIdhabilidad();
                }
                if(act == null){
                    act = volHab.getActivo();
                }
            }
            int updatedId = (int) conn.createQuery(sql)
                    .addParameter("idvoluntario", idv)
                    .addParameter("idhabilidad", idh)
                    .addParameter("activo", act)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getKey();
            voluntarioHabilidad.setId(updatedId);
            voluntarioHabilidad.setIdvoluntario(idv);
            voluntarioHabilidad.setIdhabilidad(idh);
            voluntarioHabilidad.setActivo(act);
            return voluntarioHabilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // "Elimina" un voluntarioHabilidad por id (Delete) (sólo lo desactiva)
    @Override
    public int deleteVoluntarioHabilidadById(int id){
        String sql = "UPDATE voluntariohabilidad " +
                "SET activo = false " +
                "WHERE id = :id";

        try(Connection conn = sql2o[0].open()){
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
