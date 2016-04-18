package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Abastecimento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AbastecimentoDAO implements Serializable {

    private List<Abastecimento> listarTodos;

    public AbastecimentoDAO() {

    }
    
    public void persistir(Abastecimento objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public void merge(Abastecimento objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }   
    
    public void remover(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            Abastecimento objeto = em.find(Abastecimento.class, codigo);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }      
    
    public Abastecimento getObjectById(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Abastecimento.class, codigo);
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Abastecimento> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from abastecimento order by data").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Abastecimento> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
