package tbd.grupo_seis.voluntariado.data;

import javax.persistence.*;

@Entity
@Table(name = "vol_emergencia")
public class VolEmergencia {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vol_emergencia_gen")
    @SequenceGenerator(name = "vol_emergencia_gen", sequenceName = "vol_emergencia_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_voluntario")
    private Integer id_voluntario;

    @Column(name = "id_eme")
    private Integer id_eme;

    @Column(name = "puntaje")
    private Integer puntaje;

    @Column(name = "flg_participa")
    private boolean flg_participa;

    @Column(name = "activo")
    private boolean activo;

    //Getters

    public Integer getId() {
        return id;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }

    public Integer getId_eme() {
        return id_eme;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public boolean isFlg_participa() {
        return flg_participa;
    }

    public boolean isActivo() {
        return activo;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setId_eme(Integer id_eme) {
        this.id_eme = id_eme;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public void setFlg_participa(boolean flg_participa) {
        this.flg_participa = flg_participa;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
