package view;

import entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteAtualizacao {

    public static void main(String[] args) {

        Paciente paciente = new Paciente("Robson Aparecido do Santos");

        paciente.setId_paciente(1);

        EntityManagerFactory prev = Persistence.createEntityManagerFactory("PROJETO_SINISTRO_ORACLE");

        EntityManager em = prev.createEntityManager();

        Paciente copiaGerenciada = em.merge(paciente);

        em.getTransaction().begin();
        em.getTransaction().commit();

        copiaGerenciada.setNm_completo("Robson Apparecido dos Santos");

        em.getTransaction().begin();
        em.getTransaction().commit();

        System.out.println("Paciente atualizado com sucesso!");
    }
}
