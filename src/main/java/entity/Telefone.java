package entity;

import jakarta.persistence.*;

@Entity
@Table(name="TELEFONE")
@SequenceGenerator(name="telefone", sequenceName = "TELEFONE", allocationSize=1)
public class Telefone {
    @Id
    @Column(name="id_telefone")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone")
    private Integer id_telefone;

    @Column(name="tp_contato", nullable = false, length = 20)
    private String tp_contato;

    @Column(name = "nr_tekefone", length = 9)
    private Integer nr_telefone;

    @Column(name="nr_ddd", length = 3)
    private Integer nr_ddd;

    public Telefone() {}

    public Telefone(Integer id_telefone, String tp_contato, Integer nr_telefone, Integer nr_ddd) {
        super();
        this.id_telefone = id_telefone;
        this.tp_contato = tp_contato;
        this.nr_telefone = nr_telefone;
        this.nr_ddd = nr_ddd;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(Integer id_telefone) {
        this.id_telefone = id_telefone;
    }

    public String getTp_contato() {
        return tp_contato;
    }

    public void setTp_contato(String tp_contato) {
        this.tp_contato = tp_contato;
    }

    public Integer getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(Integer nr_telefone) {
        this.nr_telefone = nr_telefone;
    }

    public Integer getNr_ddd() {
        return nr_ddd;
    }

    public void setNr_ddd(Integer nr_ddd) {
        this.nr_ddd = nr_ddd;
    }
}
