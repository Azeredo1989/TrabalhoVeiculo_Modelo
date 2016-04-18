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
import br.edu.ifsul.modelo.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ander
 */
public class TesteIserirAcessorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
            em = emf.createEntityManager();
            Acessorio a = new Acessorio();
            a.setNome("Rack");
            a.setDescricao("Para carregar a escada no carro");
            em.getTransaction().begin();
            em.persist(a); // insert
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
