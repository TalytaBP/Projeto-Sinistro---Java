package dao;

import entity.Paciente;
import exception.CommitException;
import exception.IdNaoEncontradoException;
import jakarta.persistence.EntityManager;

public abstract class Paciente_DaoImpl implements PacienteDao{

    private EntityManager em;

    public Paciente_DaoImpl(EntityManager em) {this.em = em;}

    public void cadastrar(Paciente paciente) {em.persist(paciente);}

    public void atualizar(Paciente paciente) throws IdNaoEncontradoException {
        buscarPorId_paciente(paciente.getId_paciente());
        em.merge(paciente);
    }

    public void remover(int id_paciente) throws IdNaoEncontradoException {
        Paciente paciente = buscarPorId_paciente(id_paciente);
        em.remove(paciente);
    }

    public Paciente buscarPorId_paciente(int id_paciente) throws IdNaoEncontradoException {
        Paciente paciente = em.find(Paciente.class, id_paciente);
        if(paciente == null)
            throw new IdNaoEncontradoException("Paciente não encontrado");
        return paciente;
    }

    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
