package entity;

import jakarta.persistence.*;

@Entity
@Table(name="RESULTADO")
@SequenceGenerator(name="resultado", sequenceName = "RESULTADO", allocationSize=1)
public class Resultado {

    @Id
    @Column(name="id_doenca")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultado")
    private Integer id_doenca;

    @Column(name="nm_doenca", nullable = false, length = 100)
    private String nm_doenca;

    @Column(name="tp_gravidade", nullable = false, length = 100)
    private String tp_gravidade;

    public Resultado() {}

    public Resultado(Integer id_doenca, String nm_doenca, String tp_gravidade) {
        super();
        this.id_doenca = id_doenca;
        this.nm_doenca = nm_doenca;
        this.tp_gravidade = tp_gravidade;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_doenca() {
        return id_doenca;
    }

    public void setId_doenca(Integer id_doenca) {
        this.id_doenca = id_doenca;
    }

    public String getNm_doenca() {
        return nm_doenca;
    }

    public void setNm_doenca(String nm_doenca) {
        this.nm_doenca = nm_doenca;
    }

    public String getTp_gravidade() {
        return tp_gravidade;
    }

    public void setTp_gravidade(String tp_gravidade) {
        this.tp_gravidade = tp_gravidade;
    }
}
