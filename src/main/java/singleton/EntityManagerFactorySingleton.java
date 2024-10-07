package singleton;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory unico;

    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance() {
        if (unico == null)
            unico = Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");
            return unico;
    }
}
