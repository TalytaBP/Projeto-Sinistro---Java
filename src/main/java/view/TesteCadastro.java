package view;

import entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteCadastro {

    public static void main(String[] args) {

        Paciente paciente = new Paciente("Robson Apparecido dos Santos");

        EntityManagerFactory prev = Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");

        EntityManager em = prev.createEntityManager();

        em.persist(paciente);

        em.getTransaction().begin();
        em.getTransaction().commit();

        System.out.println("Paciente cadastrado com sucesso!");
    }
}
