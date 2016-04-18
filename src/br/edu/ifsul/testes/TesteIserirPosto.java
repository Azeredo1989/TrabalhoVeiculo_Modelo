/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condutor;
import br.edu.ifsul.modelo.Deslocamento;
import br.edu.ifsul.modelo.Posto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ander
 */
public class TesteIserirPosto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
            em = emf.createEntityManager();
            Posto p= new Posto();
            p.setNome("Shoping");
            p.setBairro("Petropolis");
            p.setCnpj("47.243.868/0001-86");
            p.setEndereco("Av. Brasil");
            p.setTelefone("2134098");
            em.getTransaction().begin();
            em.persist(p); // insert
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
