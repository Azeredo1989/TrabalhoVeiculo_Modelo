package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Deslocamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DeslocamentoDAO implements Serializable {

    private List<Deslocamento> listarTodos;

    public DeslocamentoDAO() {

    }
    
    public void persistir(Deslocamento objeto) throws Exception {
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
    
    public void merge(Deslocamento objeto) throws Exception {
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
            Deslocamento objeto = em.find(Deslocamento.class, codigo);
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
    
    public Deslocamento getObjectById(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Deslocamento.class, codigo);
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Deslocamento> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from deslocamento order by data").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Deslocamento> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
