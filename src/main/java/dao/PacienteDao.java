package dao;


import entity.Paciente;
import exception.CommitException;
import exception.IdNaoEncontradoException;

public interface PacienteDao {

    void cadastrar(Paciente paciente);

    void atualizar (Paciente paciente) throws IdNaoEncontradoException;

    void remover (int id_paciente) throws IdNaoEncontradoException;

    Paciente buscarPorId_paciente (Integer id_paciente) throws IdNaoEncontradoException;

    void commit() throws CommitException;
}
