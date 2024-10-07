package view;

import entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.awt.event.ActionListener;

public class TestePesquisa {

    public static void main(String[] args) {

        EntityManagerFactory prev = Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");

        EntityManager em = prev.createEntityManager();

        Paciente paciente = em.find(Paciente.class, 1);

        System.out.println(paciente.getNm_completo());

        paciente.setNm_completo("Robson Apparecido dos Santos");

        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
