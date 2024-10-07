package entity;

import jakarta.persistence.*;

@Entity
@Table(name="ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "ENDERECO", allocationSize = 1)
public class Endereco {

    @Id
    @Column(name="id_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
    private Integer id_endereco;

    @Column(name="nr_cep")
    private Integer nr_cep;

    @Column(name="nr_complemento", nullable = false, length = 100)
    private String nr_complemento;

    public Endereco() {}

    public Endereco(Integer id_endereco, Integer nr_cep, String nr_complemento) {
        super();
        this.id_endereco = id_endereco;
        this.nr_cep = nr_cep;
        this.nr_complemento = nr_complemento;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Integer getNr_cep() {
        return nr_cep;
    }

    public void setNr_cep(Integer nr_cep) {
        this.nr_cep = nr_cep;
    }

    public String getNr_complemento() {
        return nr_complemento;
    }

    public void setNr_complemento(String nr_complemento) {
        this.nr_complemento = nr_complemento;
    }
}
