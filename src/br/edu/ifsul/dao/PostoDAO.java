package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Posto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PostoDAO implements Serializable {

    private List<Posto> listarTodos;

    public PostoDAO() {

    }
    
    public void persistir(Posto objeto) throws Exception {
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
    
    public void merge(Posto objeto) throws Exception {
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
            Posto objeto = em.find(Posto.class, codigo);
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
    
    public Posto getObjectById(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Posto.class, codigo);
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Posto> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from posto order by data").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Posto> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
