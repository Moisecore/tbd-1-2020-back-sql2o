package tbd.grupo_seis.voluntariado.data;

import javax.persistence.*;

@Entity
@Table(name = "coordinador")
public class Coordinador {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinador_gen")
    @SequenceGenerator(name = "coordinador_gen", sequenceName = "coordinador_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "institucion")
    private String institucion;

    @Column(name = "activo")
    private boolean activo;

    //Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstitucion() {
        return institucion;
    }

    public boolean isActivo() {
        return activo;
    }

    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
