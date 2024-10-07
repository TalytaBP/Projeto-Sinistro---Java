package view;

import entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class TesteRemover {

    public static void main(String[] args) {

        EntityManagerFactory prev = Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");

        EntityManager em = prev.createEntityManager();

        Paciente paciente = em.find(Paciente.class, 1);

        em.remove(paciente);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
