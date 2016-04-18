/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Abastecimento;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condutor;
import br.edu.ifsul.modelo.Deslocamento;
import br.edu.ifsul.modelo.Posto;
import br.edu.ifsul.modelo.Veiculo;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ander
 */
public class TesteIserirAbastecimento {

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
            Posto p = em.find(Posto.class, 8);
            Abastecimento a = new Abastecimento();
            a.setCombustivel("Gasolina Comun");
            a.setData(Calendar.getInstance());
            a.setKm(123.3);
            a.setQuantidade(44.95);
            a.setValor(156.38);
            v.getAbastecimentos().add(a);
            a.setPosto(p);
            a.setVeiculo(v);
//            a.getPosto().
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
