package entity;

import jakarta.persistence.*;
import oracle.jdbc.driver.Representation;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Entity
@Table(name="PACIENTE")
@SequenceGenerator(name="paciente", sequenceName = "PACIENTE", allocationSize = 1)
public class Paciente extends RepresentationModel<Paciente> implements Serializable {

    @Id
    @Column(name="id_paciente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Paciente")
    private Integer id_paciente;

    @Column(name="nm_completo", nullable = false, length = 100)
    private String nm_completo;

    @Transient
    private Integer nr_idade;

    @Enumerated(EnumType.STRING)
    @Column(name="tp_sexo", length = 20)
    private Genero tp_sexo;

    public Paciente(Integer id_paciente, String nm_completo, Integer nr_idade, Genero tp_sexo) {
        super();
        this.id_paciente = id_paciente;
        this.nm_completo = nm_completo;
        this.nr_idade = nr_idade;
        this.tp_sexo = tp_sexo;
    }

    public Paciente() {}

    @PostPersist
    private void postPersist() {System.out.println("Executando o método");}

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNm_completo() {
        return nm_completo;
    }

    public void setNm_completo(String nm_completo) {
        this.nm_completo = nm_completo;
    }

    public Integer getNr_idade() {
        return nr_idade;
    }

    public void setNr_idade(Integer nr_idade) {
        this.nr_idade = nr_idade;
    }

    public Genero getTp_sexo() {
        return tp_sexo;
    }

    public void setTp_sexo(Genero tp_sexo) {
        this.tp_sexo = tp_sexo;
    }
}