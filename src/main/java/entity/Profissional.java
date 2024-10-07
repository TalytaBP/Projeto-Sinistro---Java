package entity;

import jakarta.persistence.*;

@Entity
@Table(name="PROFISSIONAL")
@SequenceGenerator(name="profissional", sequenceName = "PROFISSIONAL", allocationSize = 1)
public class Profissional {
    @Id
    @Column(name="id_profissional")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissional")
    private Integer id_profissional;

    @Column (name="especialidade", nullable = false, length = 30)
    private String especialidade;

    @Column(name="nm_completo", nullable = false, length = 100)
    private String nm_completo;

    public Profissional() {}

    public Profissional(Integer id_profissional, String especialidade, String nm_completo) {
        super();
        this.id_profissional = id_profissional;
        this.especialidade = especialidade;
        this.nm_completo = nm_completo;
    }
    @PostPersist
    private void executando() {System.out.println("Executando o método");}

    public Integer getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(Integer id_profissional) {
        this.id_profissional = id_profissional;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNm_completo() {
        return nm_completo;
    }

    public void setNm_completo(String nm_completo) {
        this.nm_completo = nm_completo;
    }
}
