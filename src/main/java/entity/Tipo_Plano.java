package entity;

import jakarta.persistence.*;

@Entity
@Table(name="TIPO_PLANO")
@SequenceGenerator(name="tipo_plano", sequenceName = "TIPO_PLANO", allocationSize = 1)

public class Tipo_Plano {

    @Id
    @Column(name="id_tp_plano")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_plano")
    private Integer id_tp_plano;

    @Column(name="nm_palno", nullable = false, length = 20)
    private String nm_plano;

    public Tipo_Plano() {}

    public Tipo_Plano(Integer id_tp_plano, String nm_plano) {
        super();
        this.id_tp_plano = id_tp_plano;
        this.nm_plano = nm_plano;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_tp_plano() {
        return id_tp_plano;
    }

    public void setId_tp_plano(Integer id_tp_plano) {
        this.id_tp_plano = id_tp_plano;
    }

    public String getNm_plano() {
        return nm_plano;
    }

    public void setNm_plano(String nm_plano) {
        this.nm_plano = nm_plano;
    }
}