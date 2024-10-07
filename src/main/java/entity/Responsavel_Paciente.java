package entity;

import jakarta.persistence.*;

@Entity
@Table(name="RESPONSAVEL_PACIENTE")
@SequenceGenerator(name="responsavel_paciente", sequenceName = "RESPONSAVEL_PACIENTE", allocationSize = 1)

public class Responsavel_Paciente {
    @Id
    @Column(name="responsavel_paciente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsavel_paciente")
    private Integer id_responsavel;

    @Column(name="responsavel_paciente", nullable = false, length = 100)
    private String nm_completo;

    @Column(name = "nr_cpf", precision = 10, length = 11, scale = 3)
    private Integer nr_cpf;

    @Column(name="nr_rg", precision = 10, length = 9, scale = 3)
    private Integer nr_rg;

    @Column(name="tp_parentesco")
    private String tp_parentesco;

    public Responsavel_Paciente() {}

    public Responsavel_Paciente(Integer id_responsavel, String nm_completo, Integer nr_cpf, Integer nr_rg, String tp_parentesco) {
        super();
        this.id_responsavel = id_responsavel;
        this.nm_completo = nm_completo;
        this.nr_cpf = nr_cpf;
        this.nr_rg = nr_rg;
        this.tp_parentesco = tp_parentesco;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(Integer id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public String getNm_completo() {
        return nm_completo;
    }

    public void setNm_completo(String nm_completo) {
        this.nm_completo = nm_completo;
    }

    public Integer getNr_cpf() {
        return nr_cpf;
    }

    public void setNr_cpf(Integer nr_cpf) {
        this.nr_cpf = nr_cpf;
    }

    public Integer getNr_rg() {
        return nr_rg;
    }

    public void setNr_rg(Integer nr_rg) {
        this.nr_rg = nr_rg;
    }

    public String getTp_parentesco() {
        return tp_parentesco;
    }

    public void setTp_parentesco(String tp_parentesco) {
        this.tp_parentesco = tp_parentesco;
    }
}
