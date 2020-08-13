package tbd.grupo_seis.voluntariado.data;

import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;
import java.io.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tarea")
public class Tarea {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarea_gen")
    @SequenceGenerator(name = "tarea_gen", sequenceName = "tarea_seq")

    @Column(name = "id")
    private Integer id;

    @Column(name = "idVoluntario")
    private Integer idVoluntario;

    @Column(name = "idEmergencia")
    private Integer idEmergencia;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fInicio")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fInicio;

    @Column(name = "fFin")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fFin;

     @Column(name = "estado")
    private boolean estado;

     //Getters

    public Integer getId() {
        return id;
    }

    public Integer getIdVoluntario() {
        return idVoluntario;
    }

    public Integer getIdEmergencia() {
        return idEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFIni() {
        return fInicio;
    }

    public Date getFFin() {
        return fFin;
    }

    public boolean getEstado() {
        return estado;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdvoluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public void setIdemergencia(Integer idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFIni(Date fInicio) {
        this.fInicio = fInicio;
    }
    
    public void setFFin(Date fFin) {
        this.fFin = fFin;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
