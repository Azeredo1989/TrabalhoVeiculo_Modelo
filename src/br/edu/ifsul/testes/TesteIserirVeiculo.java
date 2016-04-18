/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Abastecimento;
import br.edu.ifsul.modelo.Acessorio;
import br.edu.ifsul.modelo.AcessorioVeiculo;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condutor;
import br.edu.ifsul.modelo.Deslocamento;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Posto;
import br.edu.ifsul.modelo.Veiculo;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ander
 */
public class TesteIserirVeiculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
            em = emf.createEntityManager();
            Veiculo v = new Veiculo();
            v.setCor("Branca");
            v.setModelo("Palio");
            v.setPlaca("IWK-0822");
            v.setRenavam("24334625343");
            Condutor c = em.find(Condutor.class, 7);
            v.setCondutor(c);
            Cidade cid = em.find(Cidade.class, 2);
            v.setCidade(cid);
            Marca m = em.find(Marca.class, 2);
            v.setMarca(m);
//            Abastecimento a = new Abastecimento();
//            a.setPosto(em.find(Posto.class, 8));
//            a.setCombustivel("Gasolina Comun");
//            a.setData(Calendar.getInstance());
//            a.setKm(1238.6);
//            a.setQuantidade(49.40);
//            a.setValor(156.23);
//            Deslocamento d = new Deslocamento();
//            d.setCondutor(em.find(Condutor.class, 7));
//            d.setChegada(Calendar.getInstance());
//            d.setDestino("Arena");
//            d.setOrigem("Passo Fundo");
//            d.setSaida(Calendar.getInstance());
//            AcessorioVeiculo ac = new AcessorioVeiculo();
//            ac.setDataCadastro(Calendar.getInstance());
//            ac.setDescricao("Ar condicionado");
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
