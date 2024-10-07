package entity;

import jakarta.persistence.*;

@Entity
@Table(name="ESTADO")
@SequenceGenerator(name="estado", sequenceName = "ESTADO", allocationSize = 1)
public class Estado {

    @Id
    @Column(name="id_estado")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado")
    private Integer id_estado;

    @Column(name="nm_estado", nullable = false, length = 30)
    private String nm_estado;

    public Estado() {}

    public Estado(Integer id_estado, String nm_estado) {
        super();
        this.id_estado = id_estado;
        this.nm_estado = nm_estado;
    }
    @PostPersist
    public void executar() {System.out.println("Executando o método");}

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public String getNm_estado() {
        return nm_estado;
    }

    public void setNm_estado(String nm_estado) {
        this.nm_estado = nm_estado;
    }
}
