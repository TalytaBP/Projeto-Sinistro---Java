package entity;

import jakarta.persistence.*;

@Entity
@Table(name="RUA")
@SequenceGenerator(name="rua", sequenceName = "RUA", allocationSize = 1)
public class Rua {

    @Id
    @Column(name="id_rua")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rua")
    private Integer id_rua;

    @Column(name="nm_rua", nullable = false, length = 100)
    private String nm_rua;

    public Rua () {}

    public Rua(Integer id_rua, String nm_rua) {
        super();
        this.id_rua = id_rua;
        this.nm_rua = nm_rua;
    }

    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_rua() {
        return id_rua;
    }

    public void setId_rua(Integer id_rua) {
        this.id_rua = id_rua;
    }

    public String getNm_rua() {
        return nm_rua;
    }

    public void setNm_rua(String nm_rua) {
        this.nm_rua = nm_rua;
    }
}
