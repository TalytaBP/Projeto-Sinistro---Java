package entity;

import jakarta.persistence.*;

@Entity
@Table(name="CONSULTORIO")
@SequenceGenerator(name="consultorio", sequenceName = "CONSULTORIO", allocationSize = 1)
public class Consultorio {

    @Id
    @Column(name="id_consultorio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultorio")
    private Integer id_consultorio;

    public Consultorio() {}

    public Consultorio(Integer id_consultorio) {
        super();
        this.id_consultorio = id_consultorio;
    }

    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(Integer id_consultorio) {
        this.id_consultorio = id_consultorio;
    }
}
