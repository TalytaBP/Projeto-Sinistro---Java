package dao;

import entity.Bairro;

public interface Bairro_Dao {

    void cadastrar(Bairro bairro);

    void atualizar(Bairro bairro) throws Exception;
}
