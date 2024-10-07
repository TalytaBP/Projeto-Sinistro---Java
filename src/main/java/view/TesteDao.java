package view;

import dao.PacienteDao;
import dao.Paciente_DaoImpl;
import entity.Genero;
import entity.Paciente;
import exception.CommitException;
import exception.IdNaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteDao {

    public static void main(String[] args) {

        EntityManagerFactory prev = Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");

        EntityManager em = prev.createEntityManager();

        PacienteDao dao = new Paciente_DaoImpl(em);

        Paciente paciente = new Paciente("Robson Apparecido dos Santos");

        try{
            dao.cadastrar(paciente);
            dao.commit();
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            paciente.setNm_completo("Talyta Botelho Perrotti");
            paciente.setTp_sexo(Genero.Feminino);
            dao.atualizar(paciente);
            dao.commit();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            dao.remover(2);
            dao.commit();
            System.out.println("Paciente removido com sucesso!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }
    }
}
