package entity;

import jakarta.persistence.*;

@Entity
@Table(name="REGIAO")
@SequenceGenerator(name="regiao", sequenceName = "REGIAO", allocationSize = 1)
public class Regiao {
    @Id
    @Column(name="id-regiao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regiao")
    private Integer id_regiao;

    @Column(name="nm_regiao", nullable = false, length = 50)
    private String nm_regiao;

    public Regiao() {}

    public Regiao(Integer id_regiao, String nm_regiao) {
        super();
        this.id_regiao = id_regiao;
        this.nm_regiao = nm_regiao;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_regiao() {
        return id_regiao;
    }

    public void setId_regiao(Integer id_regiao) {
        this.id_regiao = id_regiao;
    }

    public String getNm_regiao() {
        return nm_regiao;
    }

    public void setNm_regiao(String nm_regiao) {
        this.nm_regiao = nm_regiao;
    }
}
