package view;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import singleton.EntityManagerFactorySingleton;

public class Teste {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");}

        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
}
