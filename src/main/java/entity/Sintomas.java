package entity;

import jakarta.persistence.*;

@Entity
@Table(name="SINTOMAS")
@SequenceGenerator(name="sintomas", sequenceName = "SINTOMAS", allocationSize=1)
public class Sintomas {

    @Id
    @Column(name = "id_sintomas")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sintomas")
    private Integer id_sintomas;

    @Column(name="tp_sintomas", nullable = false, length = 100)
    private String tp_sintomas;

    public Sintomas() {}

    public Sintomas(Integer id_sintomas, String tp_sintomas) {
        super();
        this.id_sintomas = id_sintomas;
        this.tp_sintomas = tp_sintomas;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_sintomas() {
        return id_sintomas;
    }

    public void setId_sintomas(Integer id_sintomas) {
        this.id_sintomas = id_sintomas;
    }

    public String getTp_sintomas() {
        return tp_sintomas;
    }

    public void setTp_sintomas(String tp_sintomas) {
        this.tp_sintomas = tp_sintomas;
    }
}
