package tbd.grupo_seis.voluntariado.data;

import javax.persistence.*;

@Entity
@Table(name = "requisito_eme")
public class RequisitoEme {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requisito_eme_gen")
    @SequenceGenerator(name = "requisito_eme_gen", sequenceName = "requisito_eme_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_requisito")
    private Integer id_requisito;

    @Column(name = "id_eme")
    private Integer id_eme;

    @Column(name = "activo")
    private boolean activo;

    //Getter

    public Integer getId() {
        return id;
    }

    public Integer getId_requisito() {
        return id_requisito;
    }

    public Integer getId_eme() {
        return id_eme;
    }

    public boolean isActivo() {
        return activo;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_requisito(Integer id_requisito) {
        this.id_requisito = id_requisito;
    }

    public void setId_eme(Integer id_eme) {
        this.id_eme = id_eme;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
