package entity;

import jakarta.persistence.*;

@Entity
@Table(name="MUNICIPIO")
@SequenceGenerator(name="municipio", sequenceName = "MUNICIPIO", allocationSize = 1)
public class Municipio {

    @Id
    @Column(name="id_municipio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio")
    private Integer id_municipio;

    @Column(name="nm_municipio", nullable = false, length = 100)
    private String nm_municipio;

    public Municipio() {}
    public Municipio(Integer id_municipio, String nm_municipio) {
        super();
        this.id_municipio = id_municipio;
        this.nm_municipio = nm_municipio;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNm_municipio() {
        return nm_municipio;
    }

    public void setNm_municipio(String nm_municipio) {
        this.nm_municipio = nm_municipio;
    }
}
