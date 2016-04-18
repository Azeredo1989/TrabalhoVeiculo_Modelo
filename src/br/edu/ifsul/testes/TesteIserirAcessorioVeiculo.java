/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorio;
import br.edu.ifsul.modelo.AcessorioVeiculo;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condutor;
import br.edu.ifsul.modelo.IDAcessorioVeiculo;
import br.edu.ifsul.modelo.Veiculo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ander
 */
public class TesteIserirAcessorioVeiculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
            em = emf.createEntityManager();
            Veiculo v = em.find(Veiculo.class, 11);
            AcessorioVeiculo ac = new AcessorioVeiculo();
            ac.setDataCadastro(Calendar.getInstance());
            ac.setDescricao("A pedido do coordenador");
            IDAcessorioVeiculo id = new IDAcessorioVeiculo();
            id.setVeiculo(v);
            id.setAcessorio(em.find(Acessorio.class, 1));
            ac.setId(id);
            v.getAcessoriosveiculos().add(ac);
            em.getTransaction().begin();
            em.persist(v); // insert
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    
    }
    
}