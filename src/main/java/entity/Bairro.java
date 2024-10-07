package entity;

import jakarta.persistence.*;

@Entity
@Table(name="BAIRRO")
@SequenceGenerator(name="bairro", sequenceName = "BAIRRO", allocationSize = 1)
public class Bairro {
    @Id
    @Column(name="id_bairro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro")
    private Integer id_bairro;

    @Column(name="nm_bairro", nullable = false, length = 50)
    private String nm_bairro;

    public Bairro() {}

    public Bairro(Integer id_bairro, String nm_bairro) {
        super();
        this.id_bairro = id_bairro;
        this.nm_bairro = nm_bairro;
    }

    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(Integer id_bairro) {
        this.id_bairro = id_bairro;
    }

    public String getNm_bairro() {
        return nm_bairro;
    }

    public void setNm_bairro(String nm_bairro) {
        this.nm_bairro = nm_bairro;
    }
}
