package entity;

import jakarta.persistence.*;

@Entity
@Table(name="ANALISE_SAUDE_BUCAL")
@SequenceGenerator(name = "analise", sequenceName = "ANALISE_SAUDE_BUCAL", allocationSize = 1)

public class Analise_Saude_Bucal {
    @Id
    @Column(name="id_scanner")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "analise")
    private Integer id_scanner;

    @Column(name="qualidade_gengiva", nullable = false, length = 100)
    private String qualidade_gengiva;
    @Column(name="qualidade_dente", nullable = false, length = 100)
    private String qualidade_dente;
    @Column(name="coloracao_gengiva", nullable = false, length = 100)
    private String coloracao_gengiva;
    @Column(name="coloracao_dentes", nullable = false, length = 100)
    private String coloracao_dente;
    @Column(name="sangramento", nullable = false, length = 100)
    private String sangramento;

    public Analise_Saude_Bucal(Integer id_scanner, String qualidade_gengiva, String qualidade_dente, String coloracao_gengiva, String coloracao_dente, String sangramento, String infeccao) {
        super();
        this.id_scanner = id_scanner;
        this.qualidade_gengiva = qualidade_gengiva;
        this.qualidade_dente = qualidade_dente;
        this.coloracao_gengiva = coloracao_gengiva;
        this.coloracao_dente = coloracao_dente;
        this.sangramento = sangramento;
        this.infeccao = infeccao;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_scanner() {
        return id_scanner;
    }

    public void setId_scanner(Integer id_scanner) {
        this.id_scanner = id_scanner;
    }

    public String getQualidade_gengiva() {
        return qualidade_gengiva;
    }

    public void setQualidade_gengiva(String qualidade_gengiva) {
        this.qualidade_gengiva = qualidade_gengiva;
    }

    public String getQualidade_dente() {
        return qualidade_dente;
    }

    public void setQualidade_dente(String qualidade_dente) {
        this.qualidade_dente = qualidade_dente;
    }

    public String getColoracao_gengiva() {
        return coloracao_gengiva;
    }

    public void setColoracao_gengiva(String coloracao_gengiva) {
        this.coloracao_gengiva = coloracao_gengiva;
    }

    public String getColoracao_dente() {
        return coloracao_dente;
    }

    public void setColoracao_dente(String coloracao_dente) {
        this.coloracao_dente = coloracao_dente;
    }

    public String getSangramento() {
        return sangramento;
    }

    public void setSangramento(String sangramento) {
        this.sangramento = sangramento;
    }

    public String getInfeccao() {
        return infeccao;
    }

    public void setInfeccao(String infeccao) {
        this.infeccao = infeccao;
    }

    private String infeccao;


}
