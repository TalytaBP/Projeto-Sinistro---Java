package entity;

import jakarta.persistence.*;

@Entity
@Table(name="USUARIO")
@SequenceGenerator(name="usuario", sequenceName = "USUARIO", allocationSize = 1)
public class Usuario {
    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    private Integer id_usuario;

    @Column(name="email", nullable = false, length = 100)
    private String email;

    @Column(name="senha", nullable = false, length = 15)
    private String senha;

    public Usuario() {}

    public Usuario(Integer id_usuario, String email, String senha) {
        super();
        this.id_usuario = id_usuario;
        this.email = email;
        this.senha = senha;
    }
    @PostPersist
    private void executar() {System.out.println("Executando o método");}

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
