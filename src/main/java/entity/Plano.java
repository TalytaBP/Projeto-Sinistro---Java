package entity;

import jakarta.persistence.*;

@Entity
@Table(name="PLANO")
@SequenceGenerator(name = "plano", sequenceName = "PLANO", allocationSize = 1)
public class Plano {

    @Id
    @Column (name="id_plano")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plano")
    private Integer id_plano;
    @Column(name="nr_carteirinha", nullable = false, length = 10)
    private Integer nr_carteirinha;

    public Plano() {}

    public Plano(Integer id_plano, Integer nr_carteirinha) {
        super();
        this.id_plano = id_plano;
        this.nr_carteirinha = nr_carteirinha;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_plano() {
        return id_plano;
    }

    public void setId_plano(Integer id_plano) {
        this.id_plano = id_plano;
    }

    public Integer getNr_carteirinha() {
        return nr_carteirinha;
    }

    public void setNr_carteirinha(Integer nr_carteirinha) {
        this.nr_carteirinha = nr_carteirinha;
    }
}
