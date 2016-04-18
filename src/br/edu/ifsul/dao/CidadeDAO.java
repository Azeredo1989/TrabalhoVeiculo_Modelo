package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CidadeDAO implements Serializable {

    private List<Cidade> listarTodos;

    public CidadeDAO() {

    }
    
    public void persistir(Cidade objeto) throws Exception {
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
    
    public void merge(Cidade objeto) throws Exception {
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
            Cidade objeto = em.find(Cidade.class, codigo);
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
    
    public Cidade getObjectById(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cidade.class, codigo);
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Cidade> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from cidade order by nome").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Cidade> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
